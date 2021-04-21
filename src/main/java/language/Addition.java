package language;

public class Addition extends Expression{
    // Recursive definition of expressions
    Expression left;
    Expression right;

    public Addition(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() +
                " + " +
                right.toString();
    }
}
