package main.visitor.typeChecker;

import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.variableDec.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.ListValue;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.expression.values.primitive.StringValue;
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
import main.visitor.Visitor;

import java.util.ArrayList;


public class ExpressionTypeChecker extends Visitor<Type> {
    private final Graph<String> classHierarchy;
    private String currentClassName;
    private String currentMethodName;
    private ClassDeclaration curclass;
    private boolean access = false;
    private String accessclassname;
    private boolean islvalue;
    private boolean methodstmt = false;
    private boolean unaryLvalue = false;
    private boolean left_visit;
    private boolean isLvalue_visit = false;

    public void setLeft_visit(boolean left_visit) {
        this.left_visit = left_visit;
    }

    public void setMethodstmt(boolean methodstmt) {
        this.methodstmt = methodstmt;
    }
    public boolean getIslvalue(){
        return islvalue;
    }
    public void setIsLvalue_visit(boolean visit){ isLvalue_visit= visit;}

    public void setThisclass(ClassDeclaration thisclass) {
        this.curclass = thisclass;
    }

    public void setCurrentMethodName(String currentMethodName) {
        this.currentMethodName = currentMethodName;
    }

    public void setCurrentClassName(String currentClassName) {
        this.currentClassName = currentClassName;
    }

    public ExpressionTypeChecker(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    public boolean isLvalue(Expression expr){
        isLvalue_visit = true;
        if(expr instanceof Identifier)
            return true;
        if(expr instanceof ListAccessByIndex) {
            Expression instance = ((ListAccessByIndex) expr).getInstance();
            if(!isLvalue(instance))
                return false;
            return true;
        }
        if(expr instanceof ObjectOrListMemberAccess) {
            Expression instance = ((ObjectOrListMemberAccess) expr).getInstance();
            Type memberType = ((ObjectOrListMemberAccess) expr).getMemberName().accept(this);
            if(instance.accept(this) instanceof FptrType) {
                return false;
            }
            if(expr.accept(this) instanceof FptrType){
                return false;
            }
            if(instance instanceof ThisClass)
                return true;
            else if(!isLvalue(instance))
                return false;
            return true;
        }

        return false;
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
                        if(!(rightSubtypeLeft(rightArgsTypes.get(i),leftArgsTypes.get(i))))
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

    private SymbolTable getCurrentClassSymbolTable(String classname) {
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                    SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + classname, true);
            return classSymbolTableItem.getClassSymbolTable();
        } catch (ItemNotFoundException ignored) {
            return null;
        }
    }
    private SymbolTable getCurrentMethodSymbolTable(SymbolTable sym) {
        try {
            MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem)
                    sym.getItem(MethodSymbolTableItem.START_KEY + this.currentMethodName, true);
            return methodSymbolTableItem.getMethodSymbolTable();
        } catch (ItemNotFoundException ignored) {
            return null;
        }
    }

    private Type findinclass(Identifier id, SymbolTable curclass){
        String idname = id.getName();
        try {
            FieldSymbolTableItem fieldSymbolTableItem = (FieldSymbolTableItem)
                    curclass.getItem(FieldSymbolTableItem.START_KEY + idname, true);
            return fieldSymbolTableItem.getType();


        } catch (ItemNotFoundException i) {
            if(!isLvalue_visit) {
                VarNotDeclared exception = new VarNotDeclared(id.getLine(), idname);
                id.addError(exception);
            }
            return new NoType();

        }

    }

    private Type getIdType(Identifier id){
        String idname = id.getName();
        Type type;

        SymbolTable curclass = this.getCurrentClassSymbolTable(this.currentClassName);
        SymbolTable curmet = this.getCurrentMethodSymbolTable(curclass);
        if (curmet != null) {
            try {
                LocalVariableSymbolTableItem varSymbolTableItem = (LocalVariableSymbolTableItem)
                        curmet.getItem(LocalVariableSymbolTableItem.START_KEY + idname, true);

                return varSymbolTableItem.getType();
            } catch (ItemNotFoundException ignored) {
                if(!isLvalue_visit) {
                    VarNotDeclared exception = new VarNotDeclared(id.getLine(), id.getName());
                    id.addError(exception);
                }
                return new NoType();

            }
        }
        else
            return new NoType();

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

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        //TODO null darim?

        boolean rvalue = false;
        Expression left = binaryExpression.getFirstOperand();
        Expression right = binaryExpression.getSecondOperand();

        Type tl = left.accept(this);
        Type tr = right.accept(this);
        BinaryOperator operator =  binaryExpression.getBinaryOperator();


        if (operator.equals(BinaryOperator.and) || operator.equals(BinaryOperator.or)){
            if (tl instanceof BoolType && tr instanceof BoolType)
                return new BoolType();

            if ((tl instanceof NoType || tl instanceof BoolType) &&
                    (tr instanceof BoolType || tr instanceof NoType))
                return new NoType();
        }
        if(operator.equals(BinaryOperator.assign)){

            if(!isLvalue(left)){
                LeftSideNotLvalue exception  = new LeftSideNotLvalue(binaryExpression.getLine());
                binaryExpression.addError(exception);
                rvalue = true;
            }
            isLvalue_visit = false;
            if(assignmentHasError(tl,tr)){
                UnsupportedOperandType exception = new UnsupportedOperandType(left.getLine(),"assign");
                left.addError(exception);
                return new NoType();
            }
            if(rvalue)
                return new NoType();

            return tr;

        }
        if(operator.equals(BinaryOperator.eq) || operator.equals(BinaryOperator.neq)){
            if(tl instanceof ListType || tr instanceof ListType){
                if(!isLvalue_visit) {
                    UnsupportedOperandType exception = new UnsupportedOperandType(left.getLine(), operator.name());
                    binaryExpression.addError(exception);
                }
                return new NoType();
            }
           /* if(tr instanceof ListType){
                UnsupportedOperandType exception = new UnsupportedOperandType(right.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }*/

            if(!sameType(tl,tr)){
                if(!isLvalue_visit) {
                    UnsupportedOperandType exception = new UnsupportedOperandType(right.getLine(), operator.name());
                    binaryExpression.addError(exception);
                }
                return new NoType();
            }
            else
                return new BoolType();

        }
        if(operator.equals(BinaryOperator.gt) || operator.equals(BinaryOperator.lt)){
            if (tl instanceof IntType && tr instanceof IntType)
                return new BoolType();

            if ((tl instanceof NoType || tl instanceof IntType) &&
                    (tr instanceof IntType || tr instanceof NoType))
                return new NoType();
        }
        else { // + - / * %
            if (tl instanceof IntType && tr instanceof IntType)
                return new IntType();

            if ((tl instanceof NoType || tl instanceof IntType) &&
                    (tr instanceof IntType || tr instanceof NoType))
                return new NoType();
        }
        if(!isLvalue_visit) {
            UnsupportedOperandType exception = new UnsupportedOperandType(left.getLine(), operator.name());
            left.addError(exception);
        }
        return new NoType();

    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {

        Expression uExpr = unaryExpression.getOperand();
        Type ut = uExpr.accept(this);
        UnaryOperator operator = unaryExpression.getOperator();

        if(operator.equals(UnaryOperator.not)){

            if(ut instanceof BoolType)
                return new BoolType();
            if(ut instanceof NoType)
                return new NoType();
            else{
                if(!isLvalue_visit) {
                    UnsupportedOperandType exception = new UnsupportedOperandType(uExpr.getLine(), operator.name());
                    uExpr.addError(exception);
                }
                return new NoType();
            }
        }
        if(operator.equals(UnaryOperator.minus)) {
            if (ut instanceof IntType)
                return new IntType();
            if(ut instanceof NoType)
                return new NoType();
            else{
                if(!isLvalue_visit){
                    UnsupportedOperandType exception = new UnsupportedOperandType(uExpr.getLine(), operator.name());
                    uExpr.addError(exception);
                }
                return new NoType();
            }
        }

        else { // ++ -- //8
            boolean rvalue = false;
            if(!isLvalue(uExpr)){
                IncDecOperandNotLvalue exception = new IncDecOperandNotLvalue(unaryExpression.getLine(),operator.name());
                unaryExpression.addError(exception);
                rvalue = true;
            }
            isLvalue_visit = false;
            if (!(ut instanceof IntType || ut instanceof NoType)){
                if(!isLvalue_visit) {
                    UnsupportedOperandType exception = new UnsupportedOperandType(uExpr.getLine(), operator.name());
                    uExpr.addError(exception);
                }
                return new NoType();

            }
            else {
                if (rvalue)
                    return new NoType();
                else
                    return ut;
            }
        }

    }

    @Override
    public Type visit(ObjectOrListMemberAccess objectOrListMemberAccess) {

        Expression instance = objectOrListMemberAccess.getInstance();
        Identifier memberName = objectOrListMemberAccess.getMemberName();
        Type instanceType = instance.accept(this);
        if (instanceType instanceof ClassType){

            access = true;
            accessclassname = ((ClassType) instanceType).getClassName().getName();

        }
        if(instanceType instanceof ListType){
            ArrayList<ListNameType> elements = ((ListType) instanceType).getElementsTypes();
            for(ListNameType element : elements){
                if(memberName.getName().equals(element.getName().getName()))
                    return element.getType();
            }
            if(!isLvalue_visit) {
                ListMemberNotFound exception = new ListMemberNotFound(memberName.getLine(), memberName.getName());
                objectOrListMemberAccess.addError(exception);
            }
            return new NoType();

        }
        else if (instanceType instanceof ClassType) {
            Type memberType = memberName.accept(this);
            access = false;
            return memberType;
        }
        else if (instanceType instanceof NoType)
            return new NoType();
        else {
            if(!isLvalue_visit) {
                MemberAccessOnNoneObjOrListType exception = new MemberAccessOnNoneObjOrListType(memberName.getLine());
                objectOrListMemberAccess.addError(exception);
            }
            return new NoType();
        }


    }

    @Override
    public Type visit(Identifier identifier) {

        if (this.access){
            SymbolTable thisclass = this.getCurrentClassSymbolTable(accessclassname);
            try {
                FieldSymbolTableItem fieldSymbolTableItem = (FieldSymbolTableItem)
                        thisclass.getItem(FieldSymbolTableItem.START_KEY + identifier.getName(), true);
                Type type =  fieldSymbolTableItem.getType();
                if (type instanceof ClassType){
                    SymbolTable targetClass = this.getCurrentClassSymbolTable(((ClassType) type).getClassName().getName());
                    if (targetClass != null)
                        return type;
                    else{
                        if(!isLvalue_visit) {
                            ClassNotDeclared exception = new ClassNotDeclared(identifier.getLine(), ((ClassType) type).getClassName().getName());
                            identifier.addError(exception);
                        }
                        return new NoType();
                    }
                }

                return type;


            } catch (ItemNotFoundException i) {
                try{
                    MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem)
                            thisclass.getItem(MethodSymbolTableItem.START_KEY + identifier.getName(), true);
                    return new FptrType(methodSymbolTableItem.getArgTypes(), methodSymbolTableItem.getReturnType());

                } catch (ItemNotFoundException ex){
                    if(!isLvalue_visit) {
                        if (identifier.getName().equals(accessclassname)) {
                            ArrayList<Type> args = new ArrayList<>();
                            return new FptrType(args, new NullType());
                        }


                        MemberNotAvailableInClass exception = new MemberNotAvailableInClass(identifier.getLine(), identifier.getName(), accessclassname);
                        identifier.addError(exception);
                    }
                    return new NoType();

                }
            }


        }
        else{

            Type type = getIdType(identifier);
            if (type instanceof ClassType){
                SymbolTable targetClass = this.getCurrentClassSymbolTable(((ClassType) type).getClassName().getName());
                if (targetClass == null) {
                    if(!isLvalue_visit){
                        ClassNotDeclared exception = new ClassNotDeclared(identifier.getLine(), ((ClassType) type).getClassName().getName());
                        identifier.addError(exception);
                    }
                    return new NoType();
                }

            }

            return type;
        }
    }

    @Override
    public Type visit(ListAccessByIndex listAccessByIndex) {
        //TODO same type & expression
        Expression index = listAccessByIndex.getIndex();
        Type indexType = listAccessByIndex.getIndex().accept(this);
        Type instanceType = listAccessByIndex.getInstance().accept(this);

        boolean sameType = true;

        if(!(indexType instanceof IntType || indexType instanceof NoType)){
            if(!isLvalue_visit) {
                ListIndexNotInt exception = new ListIndexNotInt(listAccessByIndex.getLine());
                listAccessByIndex.addError(exception);
            }

        }
        if(instanceType instanceof NoType)
            return new NoType();

        if(!(instanceType instanceof ListType)){
            if(!isLvalue_visit) {
                ListAccessByIndexOnNoneList exception = new ListAccessByIndexOnNoneList(listAccessByIndex.getLine());
                listAccessByIndex.addError(exception);
            }
            return new NoType();
        }
        else { // list
            ArrayList<ListNameType> elements = ((ListType) instanceType).getElementsTypes();
            if (elements.size() > 0) {
                Type firstElementType = elements.get(0).getType();
                if (!SameTypeElements(elements))
                    sameType = false;

                if(!sameType && index instanceof IntValue){
                    int constantIndex = ((IntValue) index).getConstant();
                    if (constantIndex < elements.size())
                        return elements.get(constantIndex).getType();
                    return firstElementType;
                }
                if (!sameType && !(index instanceof IntValue)) {
                    if(!isLvalue_visit) {
                        CantUseExprAsIndexOfMultiTypeList exception = new CantUseExprAsIndexOfMultiTypeList(listAccessByIndex.getLine());
                        listAccessByIndex.addError(exception);
                    }
                }
                if (sameType && (index instanceof IntValue)) {
                    int constantIndex = ((IntValue) index).getConstant();
                    if (constantIndex < elements.size())
                        return elements.get(constantIndex).getType();
                    else
                        return firstElementType;

                }
                if(sameType && indexType instanceof IntType)
                    return firstElementType;
            }
        }
        return  new NoType();
    }

    @Override
    public Type visit(MethodCall methodCall) {

        Type type = methodCall.getInstance().accept(this);
        ArrayList<Type> rtypes = new ArrayList<>();
        for (Expression expression : methodCall.getArgs()) {
            Type t = expression.accept(this);
            rtypes.add(t);
        }

        if (!(type instanceof FptrType || type instanceof NoType)){
            if(!isLvalue_visit) {
                CallOnNoneFptrType exception = new CallOnNoneFptrType(methodCall.getLine());
                methodCall.addError(exception);
            }
            return new NoType();

        }
        if (type instanceof FptrType) {
            boolean err = false;
            if(((FptrType) type).getReturnType() instanceof ClassType){
                ClassType temp = (ClassType) ((FptrType) type).getReturnType();
                SymbolTable c = getCurrentClassSymbolTable(temp.getClassName().getName());
                if (c == null){
                    err = true;
                }

            }

            ArrayList<Type> arguments = ((FptrType) type).getArgumentsTypes();
            ArrayList<Type> argtypes = new ArrayList<>();
            if (methodCall.getArgs().size() != arguments.size()) {
                if(!isLvalue_visit) {
                    MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                    methodCall.addError(exception);
                }
                err = true;


            }
            else if (arguments.size() != 0) {
                int i = 0;
                for (Type rtype : rtypes) {
                    Type ltype = arguments.get(i);
                    if (assignmentHasError(ltype, rtype)) {
                        if(!isLvalue_visit) {
                            MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                            methodCall.addError(exception);
                        }
                        err = true;

                    }
                    i++;
                    argtypes.add(ltype);
                }
            }

            if (((FptrType) type).getReturnType() instanceof NullType && !methodstmt){
                if(!isLvalue_visit) {
                    CantUseValueOfVoidMethod exception = new CantUseValueOfVoidMethod(methodCall.getLine());
                    methodCall.addError(exception);
                }
                return new NoType();

            }
            else if (err)
                return new NoType();
            else
                return ((FptrType) type).getReturnType();
        }
        else
            return new NoType();

    }

    @Override
    public Type visit(NewClassInstance newClassInstance) {

        ClassType type = newClassInstance.getClassType();
        String classname = type.getClassName().getName();
        ClassDeclaration newclass;
        ArrayList<Type> rtypes = new ArrayList<>();
        for (Expression expression : newClassInstance.getArgs()){
            Type t = expression.accept(this);
            rtypes.add(t);
        }
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                    SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + classname, true);
            newclass = classSymbolTableItem.getClassDeclaration();
            if (newclass.getConstructor() != null) {
                ConstructorDeclaration constructor = newclass.getConstructor();
                if (constructor.getArgs().size() != newClassInstance.getArgs().size()) {
                    if(!isLvalue_visit) {
                        ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                        newClassInstance.addError(exception);
                    }
                    return new NoType();

                }
                ArrayList<VarDeclaration> arguments = constructor.getArgs();
                if (arguments.size() != 0) {
                    int i = 0;
                    for (Type rtype : rtypes) {
                        Type ltype = arguments.get(i).getType();

                        if (assignmentHasError(ltype, rtype)) {
                            if(!isLvalue_visit) {
                                ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                                newClassInstance.addError(exception);
                            }
                            return new NoType();

                        }
                        i++;
                    }
                }
            }
            else{
                if (newClassInstance.getArgs().size() != 0){
                    if(!isLvalue_visit) {
                        ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                        newClassInstance.addError(exception);
                    }
                    return new NoType();

                }
            }
            return type;
        } catch (ItemNotFoundException ignored) {
            if(!isLvalue_visit) {
                ClassNotDeclared exception = new ClassNotDeclared(newClassInstance.getLine(), classname);
                newClassInstance.addError(exception);
            }
            return new NoType();
        }




    }

    @Override
    public Type visit(ThisClass thisClass) {
        ///lazeme check she k vujud dare?
//        SymbolTable cur = this.getCurrentClassSymbolTable(currentClassName);
//        if (cur != null)
        return new ClassType(curclass.getClassName());

//        else{
//            ClassNotDeclared exception = new ClassNotDeclared(curclass.getLine(), currentClassName);
//            thisClass.addError(exception);
//            return new NoType();
//        }
    }

    @Override
    public Type visit(ListValue listValue) {

        ArrayList<ListNameType> elements;
        ListType new_list = new ListType();
        for(Expression element : listValue.getElements())
            new_list.addElementType(new ListNameType(element.accept(this)));
        return new_list;
    }

    @Override
    public Type visit(NullValue nullValue) {

        return new NullType();
    }

    @Override
    public Type visit(IntValue intValue) {

        return new IntType();
    }

    @Override
    public Type visit(BoolValue boolValue) {

        return new BoolType();
    }

    @Override
    public Type visit(StringValue stringValue) {

        return new StringType();
    }
}
