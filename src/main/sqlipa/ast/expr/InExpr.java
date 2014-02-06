package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;

public abstract class InExpr extends Expression {

    public enum Operator {
        IN,
        NOT_IN
    }
    
    private Operator op;
    
    private Expression expr;
    
    public InExpr() {
        super();
    }
    
    public InExpr(Block block, Operator op, Expression expr) {
        super(block);
        this.op = op;
        this.expr = expr;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }

}