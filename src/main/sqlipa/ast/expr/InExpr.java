package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;

public abstract class InExpr extends Expression {

    public enum Operator {
        IN,
        NOT_IN
    }
    
    public Operator operator;
    
    public Expression expr;
    
    public InExpr() {
        super();
    }
    
    public InExpr(Block block, Operator operator, Expression expr) {
        super(block);
        this.operator = operator;
        this.expr = expr;
    }

}