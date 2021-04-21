package language;

import grammar.LanguageExprBaseVisitor;
import grammar.LanguageExprParser;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Class to handle expressions
public class AntlrToExpression extends LanguageExprBaseVisitor<Expression> {

    // 'memory' to hold variables.
    private final Map<String, Integer> memory;
    // Stack to hold semantic error, e.g, undeclared variables in calculation.
    private final Stack<String> semanticErrors;

    public AntlrToExpression(Stack<String> semanticErrors){
        this.memory = new HashMap<>();
        this.semanticErrors = semanticErrors;
    }
    // Like k:INT = 5
    @Override
    public Expression visitDeclaration(LanguageExprParser.DeclarationContext ctx) {
        Token typeToken = ctx.INT_TYPE().getSymbol(); // Token for the ID
        String type = ctx.INT_TYPE().getText();

        if(!type.equals("INT")){
            semanticErrors.push("Unsupported type " + type + " at position " +
                    typeToken.getLine() + " : " + typeToken.getCharPositionInLine() + 1);
        }

        String id = ctx.ID().getText(); // identifier
        Integer number = null;
        try{
            number = Integer.parseInt(ctx.NUM().getText());
        } catch (Exception ex){
            Token valueToken = ctx.NUM().getSymbol();
            int rowNumber = valueToken.getLine();
            int columnNumber = valueToken.getCharPositionInLine() + 1;
            semanticErrors.push("Value " + ctx.NUM().getText() + "assigned to variable " + id +
                    " is not an integer. Error at: " + rowNumber + " : " + columnNumber);
        }

        // Put value in memory (upsert)
        memory.put(id, number);

        return new VariableDeclaration(id, type, number);
    }

    @Override
    public Expression visitMultiplication(LanguageExprParser.MultiplicationContext ctx) {
        Expression left = visit(ctx.getChild(0)); // Recursively visit the left child
        Expression right = visit(ctx.getChild(2)); // Recursively visit the right child

        return new Multiplication(left, right);
    }

    // Visit expr * expr
    @Override
    public Expression visitAddition(LanguageExprParser.AdditionContext ctx) {
        // expr * expr
        Expression left = visit(ctx.getChild(0)); // Recursively visit the left child
        Expression right = visit(ctx.getChild(2)); // Recursively visit the right child

        return new Addition(left, right);
    }

    // Variable, e.g k, i, t etc
    @Override
    public Expression visitVariable(LanguageExprParser.VariableContext ctx) {
        String id = ctx.ID().getText();

        if(!memory.containsKey(id)){
            Token token = ctx.ID().getSymbol();
            semanticErrors.push("Variable " + id + " has not been declared. Line " +
                        token.getLine() + " : " + token.getCharPositionInLine() + 1);
        }

        return new Variable(id);
    }

    @Override
    public Expression visitSubtraction(LanguageExprParser.SubtractionContext ctx) {
        Expression left = visit(ctx.getChild(0)); // Recursively visit the left child
        Expression right = visit(ctx.getChild(2)); // Recursively visit the right child

        return new Subtraction(left, right);
    }

    // Visit the number -> Like 1, 100, 40000, etc
    @Override
    public Expression visitNumber(LanguageExprParser.NumberContext ctx) {
        String numberString = ctx.NUM().getText();
        Integer number = null;
        try{
            number = Integer.parseInt(numberString);
        } catch (Exception ex){
            // Throw error
            return null;
        }

        return new Number(number);
    }

    @Override
    public Expression visitDivision(LanguageExprParser.DivisionContext ctx) {
        Expression left = visit(ctx.getChild(0)); // Recursively visit the left child
        Expression right = visit(ctx.getChild(2)); // Recursively visit the right child

        return new Division(left, right);
    }

    @Override
    public Expression visitAssignment(LanguageExprParser.AssignmentContext ctx) {
        Expression toAssign = visit(ctx.expr());
        String id = ctx.ID().getText();

        return new ExpressionAssignment(id, toAssign);
    }
}
