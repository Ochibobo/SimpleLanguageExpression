package language;

import grammar.LanguageExprBaseVisitor;
import grammar.LanguageExprParser;

import java.util.Stack;

// Handle the program node
public class AntlrToProgram extends LanguageExprBaseVisitor<Program> {

    // Error to be accessed by the main app
    public Stack<String> semanticErrors;


    @Override
    public Program visitProgram(LanguageExprParser.ProgramContext ctx) {
        // New program instance
        Program prog = new Program();
        // Stack to store errors
        semanticErrors = new Stack<>();
        // Helper visitor for transforming each subtree into an expression object
        AntlrToExpression antlrToExpression = new AntlrToExpression(semanticErrors);

        // Loop through all children
        // Don't visit last child as it is EOF! No need to attempt conversion to Expression
        for(int i = 0; i < ctx.getChildCount() - 1; i++){
            // Each child at position i is a subtree
            // Visit the subtree to retrieve expression
            prog.addExpression(antlrToExpression.visit(ctx.getChild(i)));
        }

        return prog;
    }

}
