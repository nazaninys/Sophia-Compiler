package main.visitor;

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
import java.util.ArrayList;
import java.util.*;
import java.util.Collection;

public class ASTTreePrinter extends Visitor<Void> {

    @Override
    public Void visit(Program program) {
        System.out.println("Line:" + program.getLine() + ":" + program.toString());
        ArrayList<ClassDeclaration> classes =  program.getClasses();
        for(ClassDeclaration my_class: classes){
            my_class.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        ArrayList<Declaration> dec = new ArrayList<>();
        System.out.println("Line:" + classDeclaration.getLine() + ":" + classDeclaration.toString());
        classDeclaration.getClassName().accept(this);
        if (classDeclaration.getParentClassName() != null) {
            classDeclaration.getParentClassName().accept(this);
        }

        ArrayList<FieldDeclaration> fields = classDeclaration.getFields();
        if (fields.size() != 0) {
            for (FieldDeclaration field : fields) {
                dec.add(field);
            }
        }

        if (classDeclaration.getConstructor() != null)
            dec.add(classDeclaration.getConstructor());

        ArrayList<MethodDeclaration> methods = classDeclaration.getMethods();
        if (methods.size() != 0) {
            for (MethodDeclaration method : methods) {
                dec.add(method);
            }
        }
        Collections.sort(dec, Declaration.lineComparator);
        if (dec.size() != 0) {
            for (Declaration item : dec) {
                item.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        ArrayList<Node> order = new ArrayList<>();
        System.out.println("Line:" + constructorDeclaration.getLine() + ":" +constructorDeclaration.toString());
        constructorDeclaration.getMethodName().accept(this);

        ArrayList<VarDeclaration> args = constructorDeclaration.getArgs();
        if (args.size() != 0) {
            for (VarDeclaration arg : args) {
                order.add(arg);
            }
        }

        ArrayList<VarDeclaration> localVars = constructorDeclaration.getLocalVars();
        if (localVars.size() != 0) {
            for (VarDeclaration localVar : localVars) {
                order.add(localVar);
            }
        }

        ArrayList<Statement> body = constructorDeclaration.getBody();
        if (body.size() != 0) {
            for (Statement stmt : body) {
                order.add(stmt);
            }
        }
        Collections.sort(order, Node.lineComparator);
        if (order.size() != 0) {
            for (Node item : order) {
                item.accept(this);
            }
        }


        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        ArrayList<Node> order = new ArrayList<>();
        System.out.println("Line:" + methodDeclaration.getLine() + ":" + methodDeclaration.toString());
        methodDeclaration.getMethodName().accept(this);

        ArrayList<VarDeclaration> args = methodDeclaration.getArgs();
        if (args.size() != 0) {
            for (VarDeclaration arg : args) {
                order.add(arg);
            }
        }

        ArrayList<VarDeclaration> localVars = methodDeclaration.getLocalVars();
        if (localVars.size() != 0) {
            for (VarDeclaration localVar : localVars) {
                order.add(localVar);
            }
        }

        ArrayList<Statement> body = methodDeclaration.getBody();
        if (body.size() != 0) {
            for (Statement stmt : body) {
                order.add(stmt);
            }
        }
        Collections.sort(order, Node.lineComparator);
        if (order.size() != 0) {
            for (Node item : order) {
                item.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        System.out.println("Line:" + fieldDeclaration.getLine() + ":" + fieldDeclaration.toString());
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDeclaration varDeclaration) {
        System.out.println("Line:" +varDeclaration.getLine() + ":" +varDeclaration.toString());
        varDeclaration.getVarName().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        System.out.println("Line:" + assignmentStmt.getLine() + ":" + assignmentStmt.toString());
        assignmentStmt.getlValue().accept(this);
        assignmentStmt.getrValue().accept(this);
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        // toString ??
        System.out.println("Line:" + blockStmt.getLine() + ":" +blockStmt.toString());
        ArrayList<Node> order = new ArrayList<>();
        ArrayList<Statement> body_statements= blockStmt.getStatements();
        if (body_statements.size() != 0) {
            for (Statement my_statement : body_statements) {
                order.add(my_statement);
            }
        }
        Collections.sort(order, Node.lineComparator);
        if (order.size() != 0) {
            for (Node item : order) {
                item.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        System.out.println("Line:" + conditionalStmt.getLine() + ":" + conditionalStmt.toString());
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);

        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        System.out.println("Line:" + methodCallStmt.getLine() + ":" + methodCallStmt.toString());
        methodCallStmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        System.out.println("Line:" + print.getLine() + ":" +print.toString());
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        System.out.println("Line:" + returnStmt.getLine() + ":" +returnStmt.toString());
        returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(BreakStmt breakStmt) {
        System.out.println("Line:" + breakStmt.getLine() + ":" +breakStmt.toString());
        return null;
    }

    @Override
    public Void visit(ContinueStmt continueStmt) {
        System.out.println("Line:" + continueStmt.getLine() + ":" +continueStmt.toString());
        return null;
    }

    @Override
    public Void visit(ForeachStmt foreachStmt) {
        //Todo?
        System.out.println("Line:" + foreachStmt.getLine() + ":" +foreachStmt.toString());

        foreachStmt.getVariable().accept(this);
        foreachStmt.getList().accept(this); //?
        foreachStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(ForStmt forStmt) {
        System.out.println("Line:" + forStmt.getLine() + ":" +forStmt.toString());

        forStmt.getInitialize().accept(this);
        forStmt.getCondition().accept(this);
        forStmt.getUpdate().accept(this);
        forStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        System.out.println("Line:" + binaryExpression.getLine() + ":" +binaryExpression.toString());

        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        System.out.println("Line:" + unaryExpression.getLine() + ":" +unaryExpression.toString());
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(ObjectOrListMemberAccess objectOrListMemberAccess) {
        ////?
        System.out.println("Line:" + objectOrListMemberAccess.getLine() + ":" +objectOrListMemberAccess.toString());
        objectOrListMemberAccess.getInstance().accept(this);
        objectOrListMemberAccess.getMemberName().accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        System.out.println("Line:" + identifier.getLine() + ":" +identifier.toString());
        return null;
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        System.out.println("Line:" + listAccessByIndex.getLine() + ":" +listAccessByIndex.toString());
        listAccessByIndex.getInstance().accept(this);
        listAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        System.out.println("Line:" + methodCall.getLine() + ":" +methodCall.toString());
        methodCall.getInstance().accept(this);
        ArrayList<Node> order = new ArrayList<>();
        ArrayList<Expression> args = methodCall.getArgs();
        if (args.size() != 0) {
            for (Expression arg : args) {
                order.add(arg);
            }
        }
        Collections.sort(order, Node.lineComparator);
        if (order.size() != 0) {
            for (Node item : order) {
                item.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(NewClassInstance newClassInstance) {
        System.out.println("Line:" + newClassInstance.getLine() + ":" + newClassInstance.toString());
        ///type??
        ArrayList<Node> order = new ArrayList<>();
        ArrayList<Expression> args = newClassInstance.getArgs();
        if (args.size() != 0) {
            for (Expression arg : args) {
                order.add(arg);
            }
        }
        Collections.sort(order, Node.lineComparator);
        if (order.size() != 0) {
            for (Node item : order) {
                item.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ThisClass thisClass) {
        System.out.println("Line:" + thisClass.getLine() + ":" + thisClass.toString());
        return null;
    }

    @Override
    public Void visit(ListValue listValue) {
        //Todo ??

        System.out.println("Line:" + listValue.getLine() + ":" + listValue.toString());
        ArrayList<Node> order = new ArrayList<>();
        ArrayList<Expression> list_elements = listValue.getElements();
        if (list_elements.size() != 0) {
            for (Expression my_expr : list_elements) {
                order.add(my_expr);
            }
        }
        Collections.sort(order, Node.lineComparator);
        if (order.size() != 0) {
            for (Node item : order) {
                item.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(NullValue nullValue) {
        System.out.println("Line:" + nullValue.getLine() + ":" + nullValue.toString());
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        System.out.println("Line:" + intValue.getLine() + ":" + intValue.toString());
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        System.out.println("Line:" + boolValue.getLine() + ":" + boolValue.toString());
        return null;
    }

    @Override
    public Void visit(StringValue stringValue) {
        System.out.println("Line:" + stringValue.getLine() + ":" + stringValue.toString());
        return null;
    }

}
