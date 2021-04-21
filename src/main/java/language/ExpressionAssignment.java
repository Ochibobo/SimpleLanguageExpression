package language;

public class ExpressionAssignment extends Expression{
    String id;
    Expression expression;

    public ExpressionAssignment(String id, Expression expression){
        this.expression = expression;
        this.id = id;
    }
}
