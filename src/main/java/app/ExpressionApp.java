package app;

import grammar.LanguageExprLexer;
import grammar.LanguageExprParser;
import language.AntlrToProgram;
import language.ExpressionProcessor;
import language.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.Stack;

public class ExpressionApp {

    public static void main(String[] args) {
        if(args.length < -1) System.err.println("Missing file name");
        else{
            //String fileName = args[0];
            String fileName = "src/main/java/test/test0.txt";
            //Retrieve the parser
            LanguageExprParser parser = getParser(fileName);

            // Build the parse tree
            ParseTree antlrAST = parser.prog();

            // Create a visitor for converting the tree to expressions
            AntlrToProgram programVisitor= new AntlrToProgram();

            // Visit the parseTree and return the program
            Program prog = programVisitor.visit(antlrAST);

            // Get the list of errors
            Stack<String> semanticErrors = programVisitor.semanticErrors;
            // Assert that there is no error
            if(semanticErrors.isEmpty()){
                // Processor takes in a list of expressions
                ExpressionProcessor processor = new ExpressionProcessor(prog.expressions);
                for(String eval: processor.getEvaluationResults()){
                    System.out.println(eval); // Print out the evaluation
                }
            }else{
                while(!semanticErrors.isEmpty()){
                    System.out.println(semanticErrors.pop());
                }
            }
        }
    }


    // Create the parser
    private static LanguageExprParser getParser(String fileName){
        LanguageExprParser parser = null;

        try {
            // Read the incoming input stream
            CharStream input = CharStreams.fromFileName(fileName);
            // Lexer to recognize the tokens
            LanguageExprLexer lexer = new LanguageExprLexer(input);
            // Get the tokens
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // Get the parser
            parser = new LanguageExprParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser;
    }
}
