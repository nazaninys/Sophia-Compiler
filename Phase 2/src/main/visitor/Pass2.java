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

public class Pass2 extends Visitor<Void>{
    private SymbolTable stack = new SymbolTable();
    private SymbolTable root;
    private Boolean cycle;
    private int error;
    public Pass2(SymbolTable root, Boolean cycle){

        this.root = root;
        this.cycle = cycle;

    }
    public int geterror_num() {return this.error;}




    @Override
    public Void visit(Program program) {

        this.stack.push(root);
        ArrayList<ClassDeclaration> classes = program.getClasses();
        for (ClassDeclaration my_class : classes) {
            SymbolTableItem cur;
            try {
                cur = root.getItem("Class_" + my_class.getClassName().getName(), Boolean.TRUE);
                SymbolTable newclass = ((ClassSymbolTableItem) cur).getClassSymbolTable();
                stack.push(newclass);
                my_class.accept(this);

            }
            catch (ItemNotFoundException e1){
            }
        }


        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {


        ArrayList<FieldDeclaration> fields = classDeclaration.getFields();

        if (fields.size() != 0) {
            for (FieldDeclaration field : fields) {
                String name = field.getVarDeclaration().getVarName().getName();

                    try {

                        this.stack.top.getItem("Field_" + name, Boolean.FALSE);
                        this.error += 1;
                        if (! field.getRedef()) {
                            System.out.println("Line:" + field.getLine() + ":" + "Redefinition of field " + name);
                            field.setRedef(Boolean.TRUE);
                        }
                    } catch (ItemNotFoundException e1) {

                    }

            }

        }

        if (classDeclaration.getConstructor() != null) {
            ConstructorDeclaration cons = classDeclaration.getConstructor();
            String name = cons.getMethodName().getName();
            try {
                this.stack.top.getItem("Method_" + name, Boolean.FALSE);
                this.error += 1;
                if (! cons.getRedef()) {
                    System.out.println("Line:" + cons.getLine() + ":" + "Redefinition of method " + name);
                    cons.setRedef(Boolean.TRUE);
                }
            } catch (ItemNotFoundException e) {

            }
            try {
                this.stack.top.getItem("Field_" + name, Boolean.FALSE);
                this.error += 1;
                if (! cons.getConflict()) {
                    System.out.println("Line:" + cons.getLine() + ":" + "Name of method " + name + " conflicts with a field's name");
                    cons.setConflict(Boolean.TRUE);
                }
            } catch (ItemNotFoundException e2) {


            }

            try{
                this.stack.top.getconflict("Field_" + name);

            } catch (ItemAlreadyExistsException e3){
                this.error += 1;
                if (!cons.getConflict()) {
                    System.out.println("Line:" + cons.getLine() + ":" + "Name of method " + name + " conflicts with a field's name");
                    cons.setConflict(Boolean.TRUE);
                }
            }
        }

        ArrayList<MethodDeclaration> methods = classDeclaration.getMethods();

        if (methods.size() != 0) {
            for (MethodDeclaration method : methods) {
                String name = method.getMethodName().getName();



                    try {
                        this.stack.top.getItem("Method_" + name, Boolean.FALSE);
                        this.error += 1;
                        if (! method.getRedef()) {
                            System.out.println("Line:" + method.getLine() + ":" + "Redefinition of method " + name);
                            method.setRedef(Boolean.TRUE);
                        }
                    } catch (ItemNotFoundException e) {

                    }
                    try {
                        this.stack.top.getItem("Field_" + name, Boolean.FALSE);
                        this.error += 1;
                        if (! method.getConflict()) {
                            System.out.println("Line:" + method.getLine() + ":" + "Name of method " + name + " conflicts with a field's name");
                            method.setConflict(Boolean.TRUE);
                        }
                    } catch (ItemNotFoundException e2) {


                    }

                try{
                    this.stack.top.getconflict("Field_" + name);

                } catch(ItemAlreadyExistsException e4){
                    this.error += 1;
                    if (!method.getConflict()) {
                        System.out.println("Line:" + method.getLine() + ":" + "Name of method " + name + " conflicts with a field's name");
                        method.setConflict(Boolean.TRUE);
                    }
                }



            }
        }

        return null;
    }


}
