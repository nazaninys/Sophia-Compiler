package main.visitor.codeGenerator;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
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
import main.ast.types.Type;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.list.ListNameType;
import main.ast.types.list.ListType;
import main.ast.types.single.BoolType;
import main.ast.types.single.ClassType;
import main.ast.types.single.IntType;
import main.ast.types.single.StringType;
import main.compileErrorException.typeErrors.MissingReturnStatement;
import main.compileErrorException.typeErrors.UnreachableStatements;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.visitor.Visitor;
import main.visitor.typeChecker.ExpressionTypeChecker;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker;
    Graph<String> classHierarchy;
    private String outputPath;
    private FileWriter currentFile;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private boolean inv_vir;
    private int label = 0;
    private boolean leftSide = false;
    private Stack<Integer> nUpdate = new Stack<>();
    private Stack<Integer> nExit = new Stack<>();

    public CodeGenerator(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
        this.prepareOutputFolder();
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) { }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) { }
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            this.currentFile = fileWriter;
        } catch (IOException e) {}
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write(
                        "\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {}
    }

    private String makeTypeSignature(Type t) {

        if(t instanceof IntType)
            return "Ljava/lang/Integer;";
        if(t instanceof BoolType)
            return "Ljava/lang/Boolean;";
        if(t instanceof StringType)
            return "Ljava/lang/String;";
        if(t instanceof ClassType)
            return "L" + ((ClassType) t).getClassName().getName() + ";";
        if(t instanceof ListType)
            return "LList;";
        if(t instanceof FptrType)
            return "LFptr;";

        return "";
    }
    private String getClassName(Type t) {

        if(t instanceof IntType)
            return "java/lang/Integer";
        if(t instanceof BoolType)
            return "java/lang/Boolean";
        if(t instanceof StringType)
            return "java/lang/String";
        if(t instanceof ClassType)
            return  ((ClassType) t).getClassName().getName() + "";
        if(t instanceof ListType)
            return "List";
        if(t instanceof FptrType)
            return "Fptr";

        return "";
    }

    private void addDefaultConstructor() {
        //todo
        String superClass = currentClass.getParentClassName().getName();
        String className = currentClass.getClassName().getName();
        addCommand(".method public <init>()V");
        addCommand( ".limit stack 128");
        addCommand(".limit locals 128");

        addCommand("aload_0");
        addCommand("invokespecial " + superClass + "/<init>()V");

        for (FieldDeclaration field : currentClass.getFields()) {
            String fieldName = field.getVarDeclaration().getVarName().getName();
            Type fieldType = field.getVarDeclaration().getType();
            addCommand("aload_0");
            initialize(fieldType);
            addCommand("putfield " + className + "/" + fieldName + " " + makeTypeSignature(fieldType));
        }

        addCommand("return");
        addCommand(".end method\n");

    }

    private void addStaticMainMethod() {

        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");

        addCommand("new Main");
        addCommand("invokespecial " + "Main/<init>()V");

        addCommand("return");
        addCommand(".end method");
        addCommand("\n");
    }

    private int slotOf(String identifier) {

        int slot = 1;
        for(VarDeclaration arg : currentMethod.getArgs()){
            if(identifier.equals(arg.getVarName().getName()))
                return slot;
            slot++;
        }
        for(VarDeclaration localVar:currentMethod.getLocalVars()){
            if(identifier.equals(localVar.getVarName().getName()))
                return slot;
            slot++;
        }

        if(identifier.equals("")){
            //todo
            VarDeclaration newvar = new VarDeclaration(new Identifier(Integer.toString(slot) + "@"), new IntType());
            currentMethod.addLocalVar(newvar);
            slot++;
            return slot;
        }

        return 0;
    }

    private void initialize(Type varType) {

        if (varType instanceof IntType) {
            addCommand("ldc 0");
            addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
        }
        if (varType instanceof BoolType) {
            addCommand("ldc 0");
            addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
        }
        if (varType instanceof StringType)
            addCommand("ldc \"\"");

        if(varType instanceof ClassType)
            addCommand("aconst_null");

        if(varType instanceof FptrType)
            addCommand("aconst_null");

        if (varType instanceof ListType) {
            //todo
            addCommand("new List");
            addCommand("dup");
            addCommand("new java/util/ArrayList");
            addCommand("dup");
            addCommand("invokespecial java/util/ArrayList/<init>()V");
            ListType listType = (ListType) varType;
            for (ListNameType listNameType : listType.getElementsTypes()) {

                addCommand("dup");
                initialize(listNameType.getType());
                addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
                addCommand("pop");
            }
            addCommand("invokespecial List/<init>(Ljava/util/ArrayList;)V");
        }

    }

    public String nonPrimitive(Type type){
        if(type instanceof IntType)
            return "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        if(type instanceof BoolType)
            return "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
        return "";
    }
    public String primitive(Type type){
        if(type instanceof IntType)
            return "invokevirtual java/lang/Integer/intValue()I\n";

        if(type instanceof BoolType)
            return "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return "";
    }

    @Override
    public String visit(Program program) {

        for(ClassDeclaration classDeclaration : program.getClasses()) {
            this.expressionTypeChecker.setCurrentClass(classDeclaration);
            this.currentClass = classDeclaration;
            classDeclaration.accept(this);

        }
        return null;
    }

    @Override
    public String visit(ClassDeclaration classDeclaration) {

        String className = classDeclaration.getClassName().getName();
        createFile(className);

        addCommand(".class " + className);

        if(classDeclaration.getParentClassName() == null)
            classDeclaration.setParentClassName(new Identifier("java/lang/Object"));

        addCommand(".super "+ classDeclaration.getParentClassName().getName());

        for(FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }

        if(classDeclaration.getConstructor() != null) {
            this.expressionTypeChecker.setCurrentMethod(classDeclaration.getConstructor());
            this.currentMethod = classDeclaration.getConstructor();
            classDeclaration.getConstructor().accept(this);
        }

        else
            addDefaultConstructor();

        for(MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            this.expressionTypeChecker.setCurrentMethod(methodDeclaration);
            this.currentMethod = methodDeclaration;
            methodDeclaration.accept(this);
        }

        return null;
    }

    @Override
    public String visit(ConstructorDeclaration constructorDeclaration) {

        if(constructorDeclaration.getArgs().size() > 0)
            addDefaultConstructor();
        if(constructorDeclaration.getMethodName().getName().equals("Main"))
            addStaticMainMethod();

        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public String visit(MethodDeclaration methodDeclaration) {
        //  method or constructor headers
        String argsTypes = "";

        for(VarDeclaration arg : methodDeclaration.getArgs()){
            argsTypes += makeTypeSignature(arg.getType());
        }
        if(methodDeclaration instanceof ConstructorDeclaration)
            addCommand(".method public <init>(" + argsTypes + ")V");

        else {
            String returnType = makeTypeSignature(methodDeclaration.getReturnType());
            if(returnType.isEmpty())
                returnType = "V";
            addCommand(".method public " + methodDeclaration.getMethodName().getName() + "("
                    + argsTypes + ")" + returnType);
        }
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");

        if(methodDeclaration instanceof ConstructorDeclaration) {

            addCommand("aload_0");
            addCommand("invokespecial " + currentClass.getParentClassName().getName()
                    +"/<init>()V");

            //todo initialize fields
            for(FieldDeclaration fieldDeclaration : currentClass.getFields()) {
                VarDeclaration field = fieldDeclaration.getVarDeclaration();
                addCommand("aload_0");
                initialize(field.getType());
                addCommand("putfield " + currentClass.getClassName().getName() + "/" + field.getVarName().getName()
                        + " " + makeTypeSignature(field.getType()));

            }
        }

        for(VarDeclaration varDeclaration : methodDeclaration.getLocalVars())
            varDeclaration.accept(this);

        for(Statement statement : methodDeclaration.getBody()) {
            statement.accept(this);
        }
        if(!methodDeclaration.getDoesReturn()){
            addCommand("return");
        }
        addCommand(".end method\n");
        return null;
    }

    @Override
    public String visit(FieldDeclaration fieldDeclaration) {

        String fieldName = fieldDeclaration.getVarDeclaration().getVarName().getName();
        Type varType = fieldDeclaration.getVarDeclaration().getType();

        addCommand(".field " + fieldName + " " + makeTypeSignature(varType));
        return null;
    }

    @Override
    public String visit(VarDeclaration varDeclaration) {

        initialize(varDeclaration.getType());
        addCommand("astore " + slotOf(varDeclaration.getVarName().getName()));
        return null;
    }

    @Override
    public String visit(AssignmentStmt assignmentStmt) {

        BinaryExpression assignmentExpression =
                new BinaryExpression(assignmentStmt.getlValue(),assignmentStmt.getrValue(),BinaryOperator.assign);
        addCommand(assignmentExpression.accept(this));
        addCommand("pop");

        return null;
    }

    @Override
    public String visit(BlockStmt blockStmt) {

        for(Statement statement : blockStmt.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ConditionalStmt conditionalStmt) {

        addCommand(conditionalStmt.getCondition().accept(this));

        if(conditionalStmt.getElseBody() == null) {
            int nAfter = label++;
            addCommand("ifeq Label" + nAfter);
            conditionalStmt.getThenBody().accept(this);
            addCommand("Label" + nAfter + ":");
        } else {
            int nElse = label++;
            int nAfter = label++;
            addCommand("ifeq Label" + nElse);
            conditionalStmt.getThenBody().accept(this);
            addCommand("goto Label" + nAfter);
            addCommand("Label" + nElse + ":");
            conditionalStmt.getElseBody().accept(this);
            addCommand("Label" + nAfter + ":");

        }
        return null;
    }

    @Override
    public String visit(MethodCallStmt methodCallStmt) {

        expressionTypeChecker.setIsInMethodCallStmt(true);
        addCommand(methodCallStmt.getMethodCall().accept(this));
        addCommand("pop");
        expressionTypeChecker.setIsInMethodCallStmt(false);
        return null;
    }

    @Override
    public String visit(PrintStmt print) {
        //todo
        Type argType = print.getArg().accept(expressionTypeChecker);
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        addCommand(print.getArg().accept(this));

        if (argType instanceof IntType) {
            addCommand("invokevirtual java/io/PrintStream/print(I)V");
        }
        if (argType instanceof BoolType){
            addCommand("invokevirtual java/io/PrintStream/print(Z)V");
        }
        if (argType instanceof StringType){
            addCommand("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
        }

        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        Type type = returnStmt.getReturnedExpr().accept(expressionTypeChecker);

        if(type instanceof NullType) {
            addCommand("return");
        }
        else {
            addCommand(returnStmt.getReturnedExpr().accept(this));
            addCommand(nonPrimitive(type));
            addCommand("areturn");
        }
        return null;
    }

    @Override
    public String visit(BreakStmt breakStmt) {

        addCommand("goto Label"+ nExit.peek());
        return null;
    }

    @Override
    public String visit(ContinueStmt continueStmt) {

        addCommand("goto Label"+ nUpdate.peek());
        return null;
    }

    @Override
    public String visit(ForeachStmt foreachStmt) {
        //todo
        int tempSlot = slotOf("");
        ListType listType = (ListType)foreachStmt.getList().accept(expressionTypeChecker);
        int listSize = listType.getElementsTypes().size();
        Type varType = foreachStmt.getVariable().accept(expressionTypeChecker);

        // i = 0 ;
        addCommand("ldc 0");
        addCommand("istore " +  tempSlot);

        int nstart = label++;
        addCommand("Label" + nstart + ":");

        int nexit = label++;
        nExit.push(nexit);

        int update = label++;
        nUpdate.push(update);

        // i < listSize
        addCommand("iload " + tempSlot);
        addCommand("ldc " + listSize);
        addCommand("if_icmpge Label" + nexit);

        // variable = list[i]
        addCommand(foreachStmt.getList().accept(this));//?
        addCommand("iload " + tempSlot);//index
        addCommand("invokevirtual List/getElement(I)Ljava/lang/Object;");
        addCommand("checkcast " + getClassName(varType));
        addCommand("astore " + slotOf(foreachStmt.getVariable().getName()));

        foreachStmt.getBody().accept(this);

        //update i = i + 1
        addCommand("Label" + update + ":");

        addCommand("iload " + tempSlot);
        addCommand("ldc 1");
        addCommand("iadd");
        addCommand("istore " + tempSlot);


        addCommand("goto Label" + nstart);
        addCommand("Label" + nexit + ":");

        nExit.pop();
        nUpdate.pop();
        return null;
    }

    @Override
    public String visit(ForStmt forStmt) {

        if(forStmt.getInitialize() != null)
            forStmt.getInitialize().accept(this);

        int nstart = label++;
        addCommand("Label" + nstart + ":");

        int nexit = label++;
        nExit.push(nexit);

        int update = label++;
        nUpdate.push(update);

        if(forStmt.getCondition() != null) {
            addCommand(forStmt.getCondition().accept(this));
            addCommand("ifeq Label" + nexit);
        }

        forStmt.getBody().accept(this);

        addCommand("Label" + update + ":");

        if(forStmt.getUpdate() != null)
            forStmt.getUpdate().accept(this);

        addCommand("goto Label" + nstart);
        addCommand("Label" + nexit + ":");

        nExit.pop();
        nUpdate.pop();

        return null;
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        String commands = "";

        if (operator == BinaryOperator.add) {

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "iadd\n";
        }
        else if (operator == BinaryOperator.sub) {

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "isub\n";
        }
        else if (operator == BinaryOperator.mult) {

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "imul\n";
        }
        else if (operator == BinaryOperator.div) {

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "idiv\n";
        }
        else if (operator == BinaryOperator.mod) {

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "irem\n";
        }
        else if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            int oneLabel = label++;
            int afterLabel = label++;

            if(operator == BinaryOperator.lt)
                commands += "if_icmplt Label" + oneLabel + "\n";

            else
                commands += "if_icmpgt Label" + oneLabel +  "\n";

            commands += "ldc 0\n";
            commands += "goto Label" + afterLabel + "\n";
            commands += "Label" + oneLabel + ":\n";
            commands += "ldc 1\n";
            commands += "Label" + afterLabel + ":\n";
        }
        else if((operator == BinaryOperator.eq) || (operator == BinaryOperator.neq)) {

            Expression first =  binaryExpression.getFirstOperand();
            Type type = first.accept(expressionTypeChecker);

            commands += first.accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);

            int zeroLabel = label++;
            int afterLabel = label++;
            if(operator == BinaryOperator.eq) {

                if(type instanceof IntType || type instanceof BoolType)
                    commands += "if_icmpne Label" + zeroLabel + "\n";
                else
                    commands += "if_acmpne Label" + zeroLabel + "\n";
            }
            else {

                if(type instanceof IntType || type instanceof BoolType)
                    commands += "if_icmpeq Label" + zeroLabel + "\n";
                else
                    commands += "if_acmpeq Label" + zeroLabel + "\n";
            }
            commands += "ldc 1\n";
            commands += "goto Label" + afterLabel + "\n";
            commands += "Label" + zeroLabel + ":\n";
            commands += "ldc 0\n";
            commands += "Label" + afterLabel + ":\n";

        }
        else if(operator == BinaryOperator.and) {

            int nElse = label++;
            int nAfter = label++;

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifeq Label"+ nElse + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "goto Label" + nAfter + "\n";
            commands += "Label" + nElse + ":\n";
            commands += "ldc 0\n";
            commands += "Label" + nAfter + ":\n";

        }
        else if(operator == BinaryOperator.or) {

            int nElse = label++;
            int nAfter = label++;

            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifeq Label"+ nElse + "\n";
            commands += "ldc 1\n";
            commands += "goto Label" + nAfter + "\n";
            commands += "Label" + nElse + ":\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "Label" + nAfter + ":\n";

        }
        else if(operator == BinaryOperator.assign) {
            commands = "";
            Type firstType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
            Type secondType = binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            String secondOperandCommands = binaryExpression.getSecondOperand().accept(this);

            /*if(firstType instanceof ListType) {
                // make new list with List copy constructor with the second operand commands
                // (add these commands to secondOperandCommands)
                secondOperandCommands += "new List\n dup\n" + secondOperandCommands +
                        "invokespecial List/<init>(LList;)V\n";

            }*/
            if(binaryExpression.getFirstOperand() instanceof Identifier) {

                commands += secondOperandCommands;
                commands += "dup\n";
                commands += nonPrimitive(firstType);

                String varName = ((Identifier) binaryExpression.getFirstOperand()).getName();
                commands += "astore " + slotOf(varName) + "\n";

            }
            else if(binaryExpression.getFirstOperand() instanceof ListAccessByIndex) {
                //todo
                ListAccessByIndex firstOperand = ((ListAccessByIndex) binaryExpression.getFirstOperand());

                commands += firstOperand.getInstance().accept(this); //ref
                commands += "dup\n";//for getElement
                commands += firstOperand.getIndex().accept(this); // index
                commands += "dup\n";
                int index = slotOf("");
                commands += "istore " + index + "\n";
                commands += secondOperandCommands; //value
                commands += nonPrimitive(secondType);
                commands += "invokevirtual List/setElement(ILjava/lang/Object;)V\n";
                commands += "iload " + index + "\n";
                commands +=  "invokevirtual List/getElement(I)Ljava/lang/Object;\n";
                commands += "checkcast " + getClassName(secondType) + "\n";
                commands += primitive(secondType);

            }
            else if(binaryExpression.getFirstOperand() instanceof ObjectOrListMemberAccess) {
                Expression instance = ((ObjectOrListMemberAccess) binaryExpression.getFirstOperand()).getInstance();
                Type memberType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
                String memberName = ((ObjectOrListMemberAccess) binaryExpression.getFirstOperand()).getMemberName().getName();
                Type instanceType = instance.accept(expressionTypeChecker);

                if(instanceType instanceof ListType) {

                    int index = 0;
                    for(ListNameType listNameType : ((ListType)instanceType).getElementsTypes()){
                        if(listNameType.getName().getName().equals(memberName))
                            break;
                        index++;
                    }
                    commands += instance.accept(this); //ref
                    commands += "dup\n"; //for setElement and getElement
                    commands += "ldc " + index + "\n";
                    commands += secondOperandCommands;//value
                    commands += nonPrimitive(secondType);
                    commands += "invokevirtual List/setElement(ILjava/lang/Object;)V\n";
                    commands += "ldc " + index + "\n";
                    commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";
                    commands += "checkcast " + getClassName(secondType) + "\n";
                    commands += primitive(secondType);
                }
                else if(instanceType instanceof ClassType) {
                    String className = ((ClassType) instanceType).getClassName().getName();

                    commands += instance.accept(this); //ref
                    commands += "dup\n"; //for putfield and getfield
                    commands += secondOperandCommands; //value (putfield)
                    commands += nonPrimitive(firstType);
                    commands += "putfield " + className + "/" + memberName + " " + makeTypeSignature(secondType) + "\n";
                    commands += "getfield " + className + "/" + memberName + " " + makeTypeSignature(secondType) + "\n";
                    commands += primitive(secondType);

                }

            }

        }
        return commands;
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        UnaryOperator operator = unaryExpression.getOperator();
        String commands = "";
        if(operator == UnaryOperator.minus) {

            commands += unaryExpression.getOperand().accept(this);
            commands += "ineg\n";
        }
        else if(operator == UnaryOperator.not) {
            //todo
            commands += unaryExpression.getOperand().accept(this);

            int AfterLabel = label++;
            int zeroLabel = label++;
            commands += "ifne Label" + zeroLabel + "\n";
            commands += "ldc 1\n";
            commands += "goto Label" + AfterLabel + "\n";
            commands += "Label" + zeroLabel + ":\n";
            commands += "ldc 0\n";
            commands += "Label" + AfterLabel + ":\n";

        }
        else if((operator == UnaryOperator.predec) || (operator == UnaryOperator.preinc)) {
            if(unaryExpression.getOperand() instanceof Identifier) {
                //todo
            }
            else if(unaryExpression.getOperand() instanceof ListAccessByIndex) {
                //todo
            }
            else if(unaryExpression.getOperand() instanceof ObjectOrListMemberAccess) {
                Expression instance = ((ObjectOrListMemberAccess) unaryExpression.getOperand()).getInstance();
                Type memberType = unaryExpression.getOperand().accept(expressionTypeChecker);
                String memberName = ((ObjectOrListMemberAccess) unaryExpression.getOperand()).getMemberName().getName();
                Type instanceType = instance.accept(expressionTypeChecker);
                if(instanceType instanceof ListType) {
                    //todo
                }
                else if(instanceType instanceof ClassType) {
                    //todo
                }
            }
        }
        else if((operator == UnaryOperator.postdec) || (operator == UnaryOperator.postinc)) {
            if(unaryExpression.getOperand() instanceof Identifier) {
                //todo
                Identifier operand = ((Identifier) unaryExpression.getOperand());
                commands += operand.accept(this);
                commands += "ldc 1\n";
                if(operator == UnaryOperator.postinc)
                    commands += "iadd\n";
                else
                    commands += "isub\n";
                commands += "dup\n";
                commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                commands += "astore " + slotOf(operand.getName()) + "\n";

            }
            else if(unaryExpression.getOperand() instanceof ListAccessByIndex) {
                //todo
            }
            else if(unaryExpression.getOperand() instanceof ObjectOrListMemberAccess) {
                Expression instance = ((ObjectOrListMemberAccess) unaryExpression.getOperand()).getInstance();
                Type memberType = unaryExpression.getOperand().accept(expressionTypeChecker);
                String memberName = ((ObjectOrListMemberAccess) unaryExpression.getOperand()).getMemberName().getName();
                Type instanceType = instance.accept(expressionTypeChecker);
                if(instanceType instanceof ListType) {
                    //todo
                }
                else if(instanceType instanceof ClassType) {
                    //todo
                }
            }
        }
        return commands;
    }

    @Override
    public String visit(ObjectOrListMemberAccess objectOrListMemberAccess) {
        Type memberType = objectOrListMemberAccess.accept(expressionTypeChecker);
        Type instanceType = objectOrListMemberAccess.getInstance().accept(expressionTypeChecker);
        String memberName = objectOrListMemberAccess.getMemberName().getName();
        String commands = "";
        if(instanceType instanceof ClassType) {
            String className = ((ClassType) instanceType).getClassName().getName();
            try {
                SymbolTable classSymbolTable = ((ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + className, true)).getClassSymbolTable();
                try {
                    classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + memberName, true);
                    // field
                    commands += objectOrListMemberAccess.getInstance().accept(this);
                    commands += "getfield " + className + "/" + memberName + " " + makeTypeSignature(memberType) + "\n";
                    commands += primitive(memberType);

                } catch (ItemNotFoundException memberIsMethod) {
                    //todo it is a method (new instance of Fptr)
                    //  commands += objectOrListMemberAccess.getInstance().accept(this);
                    commands += "new Fptr\n";
                    commands += "dup\n";
                    commands += objectOrListMemberAccess.getInstance().accept(this);
                    commands += "ldc " + '"' + memberName + '"' + "\n";
                    commands += "invokespecial " + "Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";

                }
            } catch (ItemNotFoundException classNotFound) {
            }
        }
        else if(instanceType instanceof ListType) {

            int index = 0;
            for(ListNameType listNameType : ((ListType)instanceType).getElementsTypes()){
                if(listNameType.getName().getName().equals(memberName))
                    break;
                index++;
            }

          /* ListAccessByIndex list = new ListAccessByIndex(objectOrListMemberAccess.getInstance(),new IntValue(index));
            commands += list.accept(this);

           */
            commands += objectOrListMemberAccess.getInstance().accept(this);
            commands += "ldc " + index + "\n";
            commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";
            commands += "checkcast " + getClassName(memberType) + "\n";
            commands += primitive(memberType);

        }
        return commands;
    }

    @Override
    public String visit(Identifier identifier) {
        String commands = "";

        int slot = slotOf(identifier.getName());
        if(slot < 4)
            commands += "aload_"+ slot + "\n";
        else
            commands += "aload "+ slot + "\n";

        Type type = identifier.accept(expressionTypeChecker);

        if (type instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";

        if (type instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";


        return commands;
    }

    @Override
    public String visit(ListAccessByIndex listAccessByIndex) {
        String commands = "";

        Type type = listAccessByIndex.accept(expressionTypeChecker);

        commands += listAccessByIndex.getInstance().accept(this);
        commands += listAccessByIndex.getIndex().accept(this);
        commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";

        commands += "checkcast " + getClassName(type) + "\n";
        commands +=  primitive(type);
        return commands;
    }

    @Override
    public String visit(MethodCall methodCall) {
        String commands = "";
        //todo
        Type returnType = methodCall.accept(expressionTypeChecker);

        commands += methodCall.getInstance().accept(this);
        commands += "new java/util/ArrayList\n";
        commands += "dup\n";
        commands += "invokespecial java/util/ArrayList/<init>()V\n";

        for(Expression arg :methodCall.getArgs()){
            commands += "dup\n";
            commands += arg.accept(this);
            Type type = arg.accept(expressionTypeChecker);
            commands += nonPrimitive(type);
            commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            commands += "pop\n";
        }
        commands += "invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";
        if (!(returnType instanceof NullType))
            commands += "checkcast " + getClassName(returnType) + "\n";
        commands +=  primitive(returnType) + "\n";

        return commands;
    }

    @Override
    public String visit(NewClassInstance newClassInstance) {
        String commands = "";
        String className = newClassInstance.getClassType().getClassName().getName();

        commands += "new " + className + "\n";
        commands += "dup \n";

        String signature = "";

        for(Expression expression : newClassInstance.getArgs()) {
            commands += expression.accept(this);
            Type exprType = expression.accept(expressionTypeChecker);
            signature += makeTypeSignature(exprType);

            if(exprType instanceof IntType)
                commands +="invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
            if(exprType instanceof BoolType)
                commands +="invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
        }
        commands += "invokespecial " + className + "/<init>(" + signature + ")V\n";
        //todo11
        return commands;
    }

    @Override
    public String visit(ThisClass thisClass) {
        String commands = "";

        commands += "aload_0\n";
        return commands;
    }

    @Override
    public String visit(ListValue listValue) {
        String commands = "";

        commands += "new List\n";
        commands += "dup\n";

        commands += "new java/util/ArrayList\n";
        commands += "dup\n";
        commands += "invokespecial java/util/ArrayList/<init>()V\n";

        for(Expression element : listValue.getElements()) {
            commands += "dup\n";
            commands += element.accept(this);
            Type elementType = element.accept(expressionTypeChecker);
            commands += nonPrimitive(elementType);
            commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            commands += "pop\n";

        }
        commands += "invokespecial List/<init>(Ljava/util/ArrayList;)V\n";
        return commands;

    }

    @Override
    public String visit(NullValue nullValue) {
        String commands = "";

        commands += "aconst_null\n";
        return commands;
    }

    @Override
    public String visit(IntValue intValue) {
        String commands = "";

        commands += "ldc "+ intValue.getConstant() + "\n";
        return commands;
    }

    @Override
    public String visit(BoolValue boolValue) {
        String commands = "";

        int intVal = boolValue.getConstant() ? 1 : 0;
        commands += "ldc " +  intVal + "\n";

        return commands;
    }

    @Override
    public String visit(StringValue stringValue) {
        String commands = "";

        commands += "ldc " + '"' + stringValue.getConstant() + '"' + "\n";
        return commands;
    }

}