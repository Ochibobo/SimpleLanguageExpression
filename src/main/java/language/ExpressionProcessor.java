package language;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {
    List<Expression> list;
    // Symbol table for storing the values of variables
    public Map<String, Integer> symbolTable;

    public ExpressionProcessor(List<Expression> list){
        this.list = list;
        this.symbolTable = new HashMap<>();
    }

    public List<String> getEvaluationResults(){
        List<String> evaluations = new LinkedList<>();

        for(Expression e: list){
            if(e instanceof VariableDeclaration) {
                VariableDeclaration varDecl = (VariableDeclaration) e;
                symbolTable.put(varDecl.id, varDecl.value);
                evaluations.add(varDecl.id + " = " + varDecl.value);
            }else if (e instanceof ExpressionAssignment){
                ExpressionAssignment exprAssign = (ExpressionAssignment) e;
                int result = getEvalResult(exprAssign.expression);
                symbolTable.put(exprAssign.id, result);
                evaluations.add(exprAssign.id + " = " + result);
            } else {
                // It's an evaluation
                String input = e.toString(); // The source expression
                int result = getEvalResult(e);
                evaluations.add(input + " is " + result);
            }

        }

        return evaluations;
    }

    private int getEvalResult(Expression e){
        int result = 0;

        if(e instanceof Number){
            Number num = (Number) e;
            result = num.num;
        } else if(e instanceof Variable){
            Variable var = (Variable) e;
            result = symbolTable.get(var.id);
        } else if(e instanceof Addition){
            Addition addition = (Addition) e;
            int left = getEvalResult(addition.left);
            int right = getEvalResult(addition.right);
            result = left + right;
        } else if(e instanceof Subtraction){
            Subtraction subtraction = (Subtraction) e;
            int left = getEvalResult(subtraction.left);
            int right = getEvalResult(subtraction.right);
            result = left - right;
        } else if(e instanceof Multiplication){
            Multiplication multiplication = (Multiplication) e;
            int left = getEvalResult(multiplication.left);
            int right = getEvalResult(multiplication.right);
            result = left * right;
        } else{
            // Division is all that's left
            Division division = (Division) e;
            int left = getEvalResult(division.left);
            int right = getEvalResult(division.right);
            if(right == 0) result = 0;
            else result = left / right;
        }
        return result;
    }
}
