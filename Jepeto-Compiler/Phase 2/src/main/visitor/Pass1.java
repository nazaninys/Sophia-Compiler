package main.visitor;

import com.sun.jdi.LocalVariable;
import main.ast.nodes.Program;
import main.ast.nodes.Node;
import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.ListValue;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.expression.values.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.loop.BreakStmt;
import main.ast.nodes.statement.loop.ContinueStmt;
import main.ast.nodes.statement.loop.ForStmt;
import main.ast.nodes.statement.loop.ForeachStmt;
import main.ast.types.NullType;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.SymbolTable;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.items.LocalVariableSymbolTableItem;
import main.symbolTable.items.MethodSymbolTableItem;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.*;
import java.util.Collection;




public class Pass1 extends Visitor<Void> {

    private int error;
    private SymbolTable stack = new SymbolTable();
    private Boolean cycle = Boolean.FALSE;
    SymbolTable root = new SymbolTable();


    public int geterror_num() {return this.error;}
    public SymbolTable get_root(){
        return this.root;
    }
    public Boolean getCycle(){
        return cycle;
    }



    @Override
    public Void visit(Program program) {

        this.stack.push(root);
        ArrayList<ClassDeclaration> classes = program.getClasses();

        ///////CYCLE /////
        Graph graph = new Graph();

        for(ClassDeclaration classDec : classes){
            String className = classDec.getClassName().getName();
            if (classDec.getParentClassName() != null) {
                String parent = classDec.getParentClassName().getName();
                graph.addEdge(className, parent);
                graph.set_line(className, classDec.getLine());
            }
        }
        cycle = graph.print_inheritance();

        ///////////////////
        for (ClassDeclaration my_class : classes) {
            SymbolTable newclass = new SymbolTable(root);
            ClassSymbolTableItem classsym = new ClassSymbolTableItem(my_class);
            try {
                root.put(classsym);
                classsym.setClassSymbolTable(newclass);
            } catch (ItemAlreadyExistsException e) {
                this.error += 1;
                System.out.println("Line:" + my_class.getLine() + ":" + "Redefinition of class " + my_class.getClassName().getName());
                String newname = my_class.getClassName() + Integer.toString(this.error) + "@";
                my_class.setClassName(new Identifier(newname));
                try {
                    ClassSymbolTableItem newclasssym = new ClassSymbolTableItem(my_class);
                    root.put(newclasssym);
                    newclasssym.setClassSymbolTable(newclass);
                } catch (ItemAlreadyExistsException e1) {
                }
            }


            this.stack.push(newclass);
            my_class.accept(this);
        }

        for (ClassDeclaration my_class : classes) {
            if (my_class.getParentClassName() != null){
                //SymbolTableItem cur;
                try {
                    SymbolTableItem cur = root.getItem("Class_" + my_class.getClassName().getName(), Boolean.TRUE);
                    try{
                        SymbolTableItem par;
                        par = root.getItem("Class_" + my_class.getParentClassName().getName(), Boolean.TRUE);
                        ((ClassSymbolTableItem) cur).getClassSymbolTable().pre = ((ClassSymbolTableItem) par).getClassSymbolTable();
                        ((ClassSymbolTableItem) par).getClassSymbolTable().post.add(((ClassSymbolTableItem) cur).getClassSymbolTable());


                    }
                    catch (ItemNotFoundException e2){

                    }

                }
                catch (ItemNotFoundException e1){

                }
            }
        }




        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        Set<String> str = new HashSet<String>();
        ArrayList<FieldDeclaration> fields = classDeclaration.getFields();
        if (fields.size() != 0) {
            for (FieldDeclaration field : fields) {

                str.add(field.getVarDeclaration().getVarName().getName());
                FieldSymbolTableItem fieldsym = new FieldSymbolTableItem(field);
                try {
                    this.stack.top.put(fieldsym);


                } catch (ItemAlreadyExistsException e) {
                    this.error += 1;
                    field.setRedef(Boolean.TRUE);
                    System.out.println("Line:" + field.getLine() + ":" + "Redefinition of field " + field.getVarDeclaration().getVarName().getName());
                }

            }

        }


        if (classDeclaration.getConstructor() != null) {
            ConstructorDeclaration construct = classDeclaration.getConstructor();
            MethodSymbolTableItem conssym = new MethodSymbolTableItem(construct);
            SymbolTable newcons = new SymbolTable(this.stack.top);
            try {
                this.stack.top.put(conssym);
            } catch (ItemAlreadyExistsException e) {
                this.error += 1;
                construct.setRedef(Boolean.TRUE);
                System.out.println("Line:" + construct.getLine() + ":" + "Redefinition of method " + construct.getMethodName().getName());
            }
            if (str.contains( construct.getMethodName().getName())) {
                this.error += 1;
                construct.setConflict(Boolean.TRUE);
                System.out.println("Line:" + construct.getLine() + ":" + "Name of method " + construct.getMethodName().getName() + " conflicts with a field's name");
            }
            conssym.setMethodSymbolTable(newcons);
            this.stack.push(newcons);
            construct.accept(this);
            this.stack.pop();
        }

        ArrayList<MethodDeclaration> methods = classDeclaration.getMethods();
        if (methods.size() != 0) {

            for (MethodDeclaration method : methods) {
                MethodSymbolTableItem metsym = new MethodSymbolTableItem(method);

                try {
                    this.stack.top.put(metsym);

                } catch (ItemAlreadyExistsException e) {
                    this.error += 1;
                    method.setRedef(Boolean.TRUE);
                    System.out.println("Line:" + method.getLine() + ":" + "Redefinition of method " + method.getMethodName().getName());
                    try {
                        SymbolTableItem temp = this.stack.top.getItem("Method_" + method.getMethodName().getName(), Boolean.TRUE);
                        ((MethodSymbolTableItem) temp).getMethodDeclaration().add_line(method.getLine());

                    }
                    catch (ItemNotFoundException a){

                    }


                }
                if (str.contains( method.getMethodName().getName())) {
                    this.error += 1;
                    method.setConflict(Boolean.TRUE);
                    System.out.println("Line:" + method.getLine() + ":" + "Name of method " + method.getMethodName().getName() + " conflicts with a field's name");
                }

                SymbolTable newfield = new SymbolTable(this.stack.top);
                metsym.setMethodSymbolTable(newfield);
                this.stack.push(newfield);
                method.accept(this);
                this.stack.pop();


            }

        }

        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {

        ArrayList<VarDeclaration> localVars = constructorDeclaration.getLocalVars();
        ArrayList<VarDeclaration> args = (ArrayList<VarDeclaration>) constructorDeclaration.getArgs().clone();
        args.addAll(localVars);
        if (args.size() != 0) {
            for (VarDeclaration localVar : args) {
                LocalVariableSymbolTableItem varsym = new LocalVariableSymbolTableItem(localVar);
                try {
                    this.stack.top.put(varsym);

                } catch (ItemAlreadyExistsException e) {
                    this.error += 1;
                    System.out.println("Line:" + localVar.getLine() + ":" + "Redefinition of local variable " + localVar.getVarName().getName());
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {


        ArrayList<VarDeclaration> localVars = methodDeclaration.getLocalVars();
        ArrayList<VarDeclaration> args = (ArrayList<VarDeclaration>) methodDeclaration.getArgs().clone();
        args.addAll(localVars);
        if (args.size() != 0) {
            for (VarDeclaration localVar : args) {

                LocalVariableSymbolTableItem varsym = new LocalVariableSymbolTableItem(localVar);
                try {
                    this.stack.top.put(varsym);

                } catch (ItemAlreadyExistsException e) {
                    error += 1;
                    System.out.println("Line:" + localVar.getLine() + ":" + "Redefinition of local variable " + localVar.getVarName().getName());

                }
            }
        }



        return null;
    }
}