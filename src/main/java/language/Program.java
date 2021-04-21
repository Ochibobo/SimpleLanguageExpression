package language;

import java.util.LinkedList;
import java.util.List;

public class Program {
    // Runtime attributes can be any expression
    public List<Expression> expressions;

    public Program(){
        this.expressions = new LinkedList<>();
    }

    public void addExpression(Expression e){
        this.expressions.add(e);
    }
}
