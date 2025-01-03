package main.ast.nodes;

import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.visitor.IVisitor;
import java.util.Comparator;

public abstract class Node{
    private int line;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public abstract String toString();

    public abstract <T> T accept(IVisitor<T> visitor);

    public static Comparator<Node> lineComparator = new Comparator<Node>() {

        public int compare(Node n1, Node n2) {
            int lineno1 = n1.getLine();
            int lineno2 = n2.getLine();
            return lineno1 - lineno2;

        }
    };
}

