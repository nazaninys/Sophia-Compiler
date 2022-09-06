package main.visitor.typeChecker;

import main.ast.nodes.Node;
import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VarDeclaration;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.expression.ListAccessByIndex;
import main.ast.nodes.expression.ObjectOrListMemberAccess;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.loop.BreakStmt;
import main.ast.nodes.statement.loop.ContinueStmt;
import main.ast.nodes.statement.loop.ForStmt;
import main.ast.nodes.statement.loop.ForeachStmt;
import main.ast.types.NoType;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.list.ListNameType;
import main.ast.types.list.ListType;
import main.ast.types.single.BoolType;
import main.ast.types.single.ClassType;
import main.ast.types.single.IntType;
import main.ast.types.single.StringType;
import main.compileErrorException.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.items.LocalVariableSymbolTableItem;
import main.symbolTable.items.MethodSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.symbolTable.utils.graph.exceptions.NodeAlreadyExistsException;
import main.visitor.Visitor;

import java.util.*;

public class TypeChecker extends Visitor<Void> {
    private String currentClassName;
    private MethodDeclaration curMethod;
    private final Graph<String> classHierarchy;
    private final ExpressionTypeChecker expressionTypeChecker;
    private boolean loop = false;
    private boolean havereturn = false;
    private boolean inclass = false;

    public TypeChecker(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
    }
    private SymbolTable getCurrentClassSymbolTable() {
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                    SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + this.currentClassName, true);
            return classSymbolTableItem.getClassSymbolTable();
        } catch (ItemNotFoundException ignored) {
            return null;
        }
    }

    private SymbolTable getClassSymbolTable(String name) {
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                    SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + name, true);
            return classSymbolTableItem.getClassSymbolTable();
        } catch (ItemNotFoundException ignored) {
            return null;
        }
    }

    public void type_defined(Type type, Identifier id){
        if (type instanceof ListType) {
            ListType list_type = (ListType) type;
            ArrayList<ListNameType> elements = list_type.getElementsTypes();
            if(elements.size() != 0) {
                for (ListNameType element : elements) {
                    Type elementType = element.getType();
                    if (elementType instanceof ListType || elementType instanceof FptrType)
                        type_defined(elementType,id);
                    if (elementType instanceof ClassType){
                        SymbolTable c = getClassSymbolTable(((ClassType) elementType).getClassName().getName());
                        if (c == null){
                            ClassNotDeclared exception = new ClassNotDeclared(id.getLine(), ((ClassType) elementType).getClassName().getName());
                            id.addError(exception);
                        }

                    }
                }
            }
        }
        else if(type instanceof FptrType){
            FptrType fptr_type = (FptrType)type;
            ArrayList<Type> argsTypes = fptr_type.getArgumentsTypes();
            for(Type argType : argsTypes){
                if (argType instanceof ListType || argType instanceof FptrType)
                    type_defined(argType,id);
                if (argType instanceof ClassType){
                    SymbolTable c = getClassSymbolTable(((ClassType) argType).getClassName().getName());
                    if (c == null){
                        ClassNotDeclared exception = new ClassNotDeclared(id.getLine(), ((ClassType) argType).getClassName().getName());
                        id.addError(exception);
                    }

                }
            }
            Type returnType = fptr_type.getReturnType();
            if (returnType instanceof ListType || returnType instanceof FptrType)
                type_defined(returnType,id);
            if (returnType instanceof ClassType){
                SymbolTable c = getClassSymbolTable(((ClassType) returnType).getClassName().getName());
                if (c == null){
                    ClassNotDeclared exception = new ClassNotDeclared(id.getLine(), ((ClassType) returnType).getClassName().getName());
                    id.addError(exception);

                }

            }
        }

    }

    public void EmptyList(Type type,Identifier id) {

        if (type instanceof ListType) {
            ListType list_type = (ListType) type;
            ArrayList<ListNameType> elements = list_type.getElementsTypes();
            if (elements.size() == 0){
                CannotHaveEmptyList exception = new CannotHaveEmptyList(id.getLine());
                id.addError(exception);
            }
            else {
                for (ListNameType element : elements) {
                    Type elementType = element.getType();
                    if (elementType instanceof ListType || elementType instanceof FptrType)
                        EmptyList(elementType,id) ;
                }
            }
        }
        else if(type instanceof FptrType){
            FptrType fptr_type = (FptrType)type;
            ArrayList<Type> argsTypes = fptr_type.getArgumentsTypes();
            for(Type argType : argsTypes){
                if (argType instanceof ListType || argType instanceof FptrType)
                    EmptyList(argType,id);
            }
            Type returnType = fptr_type.getReturnType();
            if (returnType instanceof ListType || returnType instanceof FptrType)
                EmptyList(returnType,id);
        }
    }

    public void DuplicatedId(Type type, Identifier id) {
        boolean HasDuplicatedId = false;

        if(type instanceof ListType){
            ListType list_type = (ListType)type;
            ArrayList<ListNameType> elements = list_type.getElementsTypes();
            Map<String, Integer> visited = new HashMap<>();

            if (elements.size() != 0) {
                for (ListNameType element : elements) {
                    String elementName = element.getName().getName();
                    Type elementType = element.getType();
                    if (visited.containsKey(elementName) && !elementName.equals("")) {
                        if (!HasDuplicatedId) {
                            DuplicateListId exception = new DuplicateListId(id.getLine());
                            id.addError(exception);
                            HasDuplicatedId = true;
                        }
                    } else
                        visited.put(elementName, 0);

                    if (elementType instanceof ListType || elementType instanceof FptrType)
                        DuplicatedId(elementType,id);
                }
            }
        }
        else if(type instanceof FptrType){
            FptrType fptr_type = (FptrType)type;
            ArrayList<Type> argsTypes = fptr_type.getArgumentsTypes();
            for(Type argType : argsTypes){
                if (argType instanceof ListType || argType instanceof FptrType)
                    DuplicatedId(argType, id);
            }
            Type returnType = fptr_type.getReturnType();
            if (returnType instanceof ListType || returnType instanceof FptrType)
                DuplicatedId(returnType, id);
        }

    }

    public boolean sameType(Type el1,Type el2){

        if(el1 instanceof NoType || el2 instanceof NoType)
            return true;
        if(el1 instanceof IntType  && el2 instanceof IntType)
            return true;
        if(el1 instanceof BoolType && el2 instanceof BoolType)
            return true;
        if(el1 instanceof StringType && el2 instanceof StringType)
            return true;
        if(el1 instanceof NullType && el2 instanceof NullType)
            return true;
       /* if(el1 instanceof NullType && (el2 instanceof ClassType || el2 instanceof FptrType))
            return true;
        if(el2 instanceof NullType && (el1 instanceof ClassType || el1 instanceof FptrType))
            return true;*/
        if(el1 instanceof ClassType && el2 instanceof ClassType) {
            String el1Name = ((ClassType) el1).getClassName().getName();
            String el2Name = ((ClassType) el2).getClassName().getName();
            if (el1Name.equals(el2Name))
                return true;
        }
        if (el1 instanceof ListType && el2 instanceof ListType){
            ArrayList<ListNameType> list1 = ((ListType) el1).getElementsTypes();
            ArrayList<ListNameType> list2 = ((ListType) el2).getElementsTypes();
            if(list1.size() != list2.size())
                return false;
            else {
                for(int i = 0; i < list1.size(); i++){
                    if(!sameType(list1.get(i).getType(),list2.get(i).getType()))
                        return false;
                }
            }
            return true;

        }
        if(el1 instanceof FptrType && el2 instanceof FptrType){

            Type el1RetType = ((FptrType) el1).getReturnType();
            Type el2RetType = ((FptrType) el2).getReturnType();
            if(!sameType(el1RetType,el2RetType))
                return false;
            ArrayList<Type> el1ArgsTypes = ((FptrType) el1).getArgumentsTypes();
            ArrayList<Type> el2ArgsTypes = ((FptrType) el2).getArgumentsTypes();

            if(el1ArgsTypes.size() != el2ArgsTypes.size())
                return false;
            else{
                for(int i = 0; i < el1ArgsTypes.size(); i++){
                    if(!sameType(el1ArgsTypes.get(i),el2ArgsTypes.get(i)))
                        return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean SameTypeElements(ArrayList<ListNameType> types) {

        Type prevType = types.get(0).getType();
        for (ListNameType type : types) {
            Type curType = type.getType();
            if (!sameType(curType, prevType))
                return false;
            prevType = curType;
        }
        return true;
    }

    public boolean assignmentHasError(Type lType, Type rType){

        if(lType instanceof NullType && !(rType instanceof NullType || rType instanceof NoType))
            return true;
        if ((lType instanceof IntType && !(rType instanceof IntType || rType instanceof NoType)))
            return true;
        if ((lType instanceof BoolType && !(rType instanceof BoolType || rType instanceof NoType)))
            return true;
        if ((lType instanceof StringType && !(rType instanceof StringType || rType instanceof NoType)))
            return true;
        if ((lType instanceof ListType && !(rType instanceof ListType || rType instanceof NoType)))
            return true;

        if(lType instanceof ClassType) {
            if (!(rType instanceof ClassType || rType instanceof NullType || rType instanceof NoType))
                return true;
            else if (rType instanceof ClassType) {
                String rName = ((ClassType) rType).getClassName().getName();
                String lName = ((ClassType) lType).getClassName().getName();
                if (!(classHierarchy.isSecondNodeAncestorOf(rName, lName) || rName.equals(lName)))
                    return true;
            }
        }
        if(lType instanceof ListType && rType instanceof ListType){
            ArrayList<ListNameType> lList = ((ListType) lType).getElementsTypes();
            ArrayList<ListNameType> rList = ((ListType) rType).getElementsTypes();
            if(lList.size() != rList.size())
                return true;
            else {
                for(int i = 0; i < lList.size(); i++){
                    if(assignmentHasError(lList.get(i).getType(),rList.get(i).getType()))
                        return true;
                }
            }

        }

        if(lType instanceof FptrType ){
            if(!(rType instanceof NullType || rType instanceof FptrType || rType instanceof NoType))
                return true;
            if(rType instanceof FptrType){
                ArrayList<Type> leftArgsTypes = ((FptrType) lType).getArgumentsTypes();
                ArrayList<Type> rightArgsTypes = ((FptrType) rType).getArgumentsTypes();

                 Type rightRetType = ((FptrType) rType).getReturnType();
                 Type leftRetType = ((FptrType) lType).getReturnType();
                 if(assignmentHasError(leftRetType,rightRetType))
                     return true;
                if(leftArgsTypes.size() != rightArgsTypes.size())
                      return true;
                 else{
                 for(int i = 0; i < leftArgsTypes.size(); i++){
                    if(!rightSubtypeLeft(rightArgsTypes.get(i),leftArgsTypes.get(i)))
                        return true;
                 }
               }
            }
        }
        return false;

    }
    public boolean rightSubtypeLeft(Type lType,Type rType){
        if(lType instanceof NoType || rType instanceof NoType)
            return true;
        if(lType instanceof NullType && rType instanceof NullType)
            return true;
        if ((lType instanceof IntType && (rType instanceof IntType)))
            return true;
        if ((lType instanceof BoolType && rType instanceof BoolType))
            return true;
        if ((lType instanceof StringType && (rType instanceof StringType)))
            return true;

        if(lType instanceof ClassType) {
            if (rType instanceof NullType)
                return true;
            else if (rType instanceof ClassType) {
                String rName = ((ClassType) rType).getClassName().getName();
                String lName = ((ClassType) lType).getClassName().getName();
                if (classHierarchy.isSecondNodeAncestorOf(rName, lName) || rName.equals(lName))
                    return true;
            }
        }
        if(lType instanceof ListType && rType instanceof ListType){
            ArrayList<ListNameType> lList = ((ListType) lType).getElementsTypes();
            ArrayList<ListNameType> rList = ((ListType) rType).getElementsTypes();
            if(lList.size() != rList.size())
                return true;
            else {
                for(int i = 0; i < lList.size(); i++){
                    if(!(rightSubtypeLeft(lList.get(i).getType(),rList.get(i).getType())))
                        return false;
                }
            }
            return true;
        }

        if(lType instanceof FptrType ){
            if(rType instanceof NullType)
                return true;
            if(rType instanceof FptrType){
                ArrayList<Type> leftArgsTypes = ((FptrType) lType).getArgumentsTypes();
                ArrayList<Type> rightArgsTypes = ((FptrType) rType).getArgumentsTypes();

                Type rightRetType = ((FptrType) rType).getReturnType();
                Type leftRetType = ((FptrType) lType).getReturnType();
                if(!(rightSubtypeLeft(leftRetType,rightRetType)))
                    return false;
                if(leftArgsTypes.size() != rightArgsTypes.size())
                    return false;
                else{
                    for(int i = 0; i < leftArgsTypes.size(); i++){
                        if(!(rightSubtypeLeft(rightArgsTypes.get(i),leftArgsTypes.get(i))))
                            return false;
                    }
                    return true;
                }
            }
        }
        return false;

    }
    private SymbolTable getCurrentMethodSymbolTable(SymbolTable sym) {
        try {
            MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem)
                    sym.getItem(MethodSymbolTableItem.START_KEY + this.curMethod.getMethodName().getName(), true);
            return methodSymbolTableItem.getMethodSymbolTable();
        } catch (ItemNotFoundException ignored) {
            return null;
        }
    }
    public void set_notype(Identifier id) {
        SymbolTable thisclass = this.getCurrentClassSymbolTable();

        if (this.inclass) {

            try {
                FieldSymbolTableItem fieldSymbolTableItem = (FieldSymbolTableItem)
                        thisclass.getItem(FieldSymbolTableItem.START_KEY + id.getName(), true);
                fieldSymbolTableItem.setType(new NoType());

            } catch (ItemNotFoundException i) {
            }
        }
        else {

            SymbolTable curmet = this.getCurrentMethodSymbolTable(thisclass);

            try {
                LocalVariableSymbolTableItem varSymbolTableItem = (LocalVariableSymbolTableItem)
                        curmet.getItem(LocalVariableSymbolTableItem.START_KEY + id.getName(), true);
                varSymbolTableItem.setType(new NoType());


            } catch (ItemNotFoundException ignored){

            }


        }
    }


    @Override
    public Void visit(Program program) {
        boolean hasMain = false;
        for(ClassDeclaration classDeclaration : program.getClasses()) {
            String className = classDeclaration.getClassName().getName();
            if (className.equals("Main")) {
                hasMain = true;
                break;
            }
        }
        if(!hasMain){
            NoMainClass exception = new NoMainClass();
            program.addError(exception);
        }
        for(ClassDeclaration classDeclaration : program.getClasses()) {
            String className = classDeclaration.getClassName().getName();
            if (classDeclaration.getParentClassName() != null){
                this.currentClassName = classDeclaration.getParentClassName().getName();
                SymbolTable par = this.getCurrentClassSymbolTable();
                if (par == null){
                    ClassNotDeclared exception = new ClassNotDeclared(classDeclaration.getLine(), currentClassName);
                    program.addError(exception);

                }
            }
            this.currentClassName = className;
            this.expressionTypeChecker.setCurrentClassName(className);
            this.expressionTypeChecker.setThisclass(classDeclaration);
            classDeclaration.accept(this);
        }


        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        String className = classDeclaration.getClassName().getName();

        if (classDeclaration.getParentClassName() != null) {
            String parentName = classDeclaration.getParentClassName().getName();
            if (parentName.equals("Main")) {
                CannotExtendFromMainClass exception = new CannotExtendFromMainClass(classDeclaration.getLine());
                classDeclaration.addError(exception);//27
            }
            if (className.equals("Main")) {
                MainClassCantExtend exception = new MainClassCantExtend(classDeclaration.getLine());
                classDeclaration.addError(exception);//26
            }
        }
        inclass = true;
        for (FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {

            fieldDeclaration.accept(this);
        }
        inclass = false;
        if (className.equals("Main") && classDeclaration.getConstructor() == null) {
            NoConstructorInMainClass exception = new NoConstructorInMainClass(classDeclaration);
            classDeclaration.addError(exception);//28
        }

        if (classDeclaration.getConstructor() != null) {
            this.curMethod = classDeclaration.getConstructor();
            this.expressionTypeChecker.setCurrentMethodName(classDeclaration.getConstructor().getMethodName().getName());
            classDeclaration.getConstructor().accept(this);


        }

        for (MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            this.expressionTypeChecker.setCurrentMethodName(methodDeclaration.getMethodName().getName());
            curMethod = methodDeclaration;
            methodDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        String constructorName = constructorDeclaration.getMethodName().getName();

        if (!(this.currentClassName.equals(constructorName))) {
            ConstructorNotSameNameAsClass exception = new ConstructorNotSameNameAsClass(constructorDeclaration.getLine());
            constructorDeclaration.addError(exception);

        }
        if (constructorName.equals("Main") && this.currentClassName.equals("Main")) {
            if (constructorDeclaration.getArgs().size() > 0) {
                MainConstructorCantHaveArgs exception = new MainConstructorCantHaveArgs(constructorDeclaration.getLine());
                constructorDeclaration.addError(exception);
            }
        }
        ArrayList<VarDeclaration> args = constructorDeclaration.getArgs();
        if (args.size() != 0) {
            for (VarDeclaration arg : args) {
                arg.accept(this);
            }
        }

        ArrayList<VarDeclaration> localVars = constructorDeclaration.getLocalVars();
        if (localVars.size() != 0) {
            for (VarDeclaration localVar : localVars) {
                localVar.accept(this);
            }
        }

        ArrayList<Statement> body = constructorDeclaration.getBody();
        if (body.size() != 0) {
            for (Statement stmt : body) {
                stmt.accept(this);
            }
        }
        havereturn = false;
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        ArrayList<VarDeclaration> args = methodDeclaration.getArgs();
        if (args.size() != 0) {
            for (VarDeclaration arg : args) {
                arg.accept(this);
            }
        }

        ArrayList<VarDeclaration> localVars = methodDeclaration.getLocalVars();
        if (localVars.size() != 0) {
            for (VarDeclaration localVar : localVars) {
                localVar.accept(this);
            }
        }

        ArrayList<Statement> body = methodDeclaration.getBody();
        if (body.size() != 0) {
            for (Statement stmt : body) {
                stmt.accept(this);
            }
        }
        if (!(methodDeclaration.getReturnType() instanceof NullType)){

            if (!this.havereturn){
                MissingReturnStatement exception = new MissingReturnStatement(methodDeclaration);
                methodDeclaration.addError(exception);
            }
        }
        this.havereturn = false;
        if (methodDeclaration.getReturnType() instanceof ClassType){
            ClassType ret = (ClassType) methodDeclaration.getReturnType();
            try {
                ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                        SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY +ret.getClassName().getName() , true);
            } catch (ItemNotFoundException ignored) {
                ClassNotDeclared exception = new ClassNotDeclared(methodDeclaration.getLine(), ret.getClassName().getName());
                methodDeclaration.addError(exception);
            }

        }
        Type retType = methodDeclaration.getReturnType();
        if(retType instanceof ListType || retType instanceof FptrType){

            EmptyList(retType,methodDeclaration.getMethodName());
            DuplicatedId(retType,methodDeclaration.getMethodName());
            type_defined(retType, methodDeclaration.getMethodName());
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDeclaration varDeclaration) {

        Type varType = varDeclaration.getType();
        if(varType instanceof ListType || varType instanceof FptrType){

            EmptyList(varType,varDeclaration.getVarName());
            DuplicatedId(varType, varDeclaration.getVarName());
            type_defined(varType, varDeclaration.getVarName());
            if(varDeclaration.getVarName().hasError())
                set_notype(varDeclaration.getVarName());

        }
        if (varType instanceof ClassType){
            ClassType t = (ClassType) varType;
            try {
                ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                        SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY +t.getClassName().getName() , true);
            } catch (ItemNotFoundException ignored) {
                ClassNotDeclared exception = new ClassNotDeclared(varDeclaration.getLine(), t.getClassName().getName());
                varDeclaration.addError(exception);
                set_notype(varDeclaration.getVarName());
            }

        }

        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {

        Expression lExpr = assignmentStmt.getlValue();

        Expression rExpr = assignmentStmt.getrValue();
        boolean error = false;
        //   expressionTypeChecker.setLeft_visit(true);
        Type lType = assignmentStmt.getlValue().accept(expressionTypeChecker);
        if(!expressionTypeChecker.isLvalue(lExpr)){
            LeftSideNotLvalue exception  = new LeftSideNotLvalue(assignmentStmt.getLine());
            assignmentStmt.addError(exception);
        }
        expressionTypeChecker.setIsLvalue_visit(false);
        //  expressionTypeChecker.setLeft_visit(false);
        Type rType = assignmentStmt.getrValue().accept(expressionTypeChecker);

        if(assignmentHasError(lType,rType)){
            UnsupportedOperandType exception = new UnsupportedOperandType(assignmentStmt.getLine(),"assign");
            assignmentStmt.addError(exception);
        }

        return null;

    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        boolean rep = false;
        if (loop)
            rep = true;
        ArrayList<Statement> body_statements= blockStmt.getStatements();
        if (body_statements.size() != 0) {
            for (Statement my_statement : body_statements) {
                if(rep)
                    loop = true;
                my_statement.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(conditionalStmt.getLine());
            conditionalStmt.addError(exception);
        }
        conditionalStmt.getThenBody().accept(this);
        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        expressionTypeChecker.setMethodstmt(true);
        methodCallStmt.getMethodCall().accept(expressionTypeChecker);
        expressionTypeChecker.setMethodstmt(false);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType =  print.getArg().accept(expressionTypeChecker);
        if(!(argType instanceof BoolType || argType instanceof StringType
                || argType instanceof IntType || argType instanceof NoType)) {
            UnsupportedTypeForPrint exception = new UnsupportedTypeForPrint(print.getLine());
            print.addError(exception);
        }

        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        Type returnType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);

        if(assignmentHasError(curMethod.getReturnType(), returnType)){
            ReturnValueNotMatchMethodReturnType exception = new ReturnValueNotMatchMethodReturnType(returnStmt);
            returnStmt.addError(exception);
        }
        this.havereturn = true;
        return null;
    }

    @Override
    public Void visit(BreakStmt breakStmt) {
        if (! loop){
            ContinueBreakNotInLoop exception = new ContinueBreakNotInLoop(breakStmt.getLine(), 0);
            breakStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ContinueStmt continueStmt) {
        if (! loop){
            ContinueBreakNotInLoop exception = new ContinueBreakNotInLoop(continueStmt.getLine(), 1);
            continueStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ForeachStmt foreachStmt) {
        loop = true;
        Type itType = foreachStmt.getVariable().accept(expressionTypeChecker);
        Type listType = foreachStmt.getList().accept(expressionTypeChecker);

        if(listType instanceof NoType)
            return null;

        else if(!(listType instanceof ListType)){
            ForeachCantIterateNoneList exception = new ForeachCantIterateNoneList(foreachStmt.getLine());
            foreachStmt.addError(exception);
        }
        else {
            ArrayList<ListNameType> elements = ((ListType) listType).getElementsTypes();
            if(elements.size() > 0){
                Type firstElementType = elements.get(0).getType();

                if(!SameTypeElements(elements)){
                    ForeachListElementsNotSameType exception = new ForeachListElementsNotSameType(foreachStmt.getLine());
                    foreachStmt.addError(exception);

                }
                if(!(sameType(firstElementType, itType))){
                    ForeachVarNotMatchList exception = new ForeachVarNotMatchList(foreachStmt);
                    foreachStmt.addError(exception);
                }

            }
        }
        foreachStmt.getBody().accept(this);

        loop = false;
        return null;

    }

    @Override
    public Void visit(ForStmt forStmt) {
        loop = true;
        if(forStmt.getInitialize() != null) {
            forStmt.getInitialize().accept(this);
        }
        if(forStmt.getCondition() != null) {
            Type condType = forStmt.getCondition().accept(expressionTypeChecker);
            if(!(condType instanceof BoolType || condType instanceof NoType)) {
                ConditionNotBool exception = new ConditionNotBool(forStmt.getLine());
                forStmt.addError(exception);
            }
        }
        if(forStmt.getUpdate() != null) {
            forStmt.getUpdate().accept(this);
        }
        forStmt.getBody().accept(this);
        loop = false;
        return null;
    }

}
