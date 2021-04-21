package language;

public class Multiplication extends Expression{
    // Recursive definition of expressions
    Expression left;
    Expression right;

    public Multiplication(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() +
                " * " +
                right.toString();
    }
}
