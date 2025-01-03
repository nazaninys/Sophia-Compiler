package main;

import main.ast.nodes.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.SophiaLexer;
import parsers.SophiaParser;
import main.visitor.ASTTreePrinter;
import main.visitor.Visitor;
import main.visitor.Pass1;
import main.visitor.Pass2;

public class SophiaCompiler {
    public void compile(CharStream textStream) {
        SophiaLexer sophiaLexer = new SophiaLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(sophiaLexer);
        SophiaParser sophiaParser = new SophiaParser(tokenStream);
        Program program = sophiaParser.sophia().sophiaProgram;
        Pass1 pass1 = new Pass1();
        program.accept(pass1);
        Pass2 pass2 = new Pass2(pass1.get_root(), pass1.getCycle());
        program.accept(pass2);
        if (pass1.geterror_num() == 0 && pass2.geterror_num() == 0) {
            Visitor<Void> treePrinter = new ASTTreePrinter();
            program.accept(treePrinter);
        }


        //Todo

    }

}
