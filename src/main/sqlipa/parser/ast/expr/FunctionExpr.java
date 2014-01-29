package main.sqlipa.parser.ast.expr;

import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class FunctionExpr extends Expression {

    public enum Operator {
        DISTINCT,
        UNIVERSAL
    }
    
    private Name function;
    
    private Operator op;
    
    private List<Expression> exprs;
    
    public FunctionExpr() {
        super();
    }
    
    public FunctionExpr(Block block, Name function, Operator op,
            List<Expression> exprs) {
        super(block);
        this.function = function;
        this.op = op;
        this.exprs = exprs;
    }
    
    public Name getFunction() {
        return function;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public List<Expression> getExpressions() {
        return exprs;
    }
    
    public void setFunction(Name function) {
        this.function = function;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
    public void setExpressions(List<Expression> exprs) {
        this.exprs = exprs;
    }
    
    public void addExpression(Expression expr) {
        exprs.add(expr);
    }
    
    public boolean removeExpression(Expression expr) {
        return exprs.remove(expr);
    }
    
}