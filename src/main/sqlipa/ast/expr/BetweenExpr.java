package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class BetweenExpr extends Expression {

    public enum Operator {
        BETWEEN,
        NOT_BETWEEN
    }
    
    public Expression expr;
    
    public Expression lower;
    
    public Expression upper;
    
    public Operator operator;
    
    public BetweenExpr() {
        super();
    }
    
    public BetweenExpr(Block block, Expression expr, Expression lower, Expression upper,
            Operator operator) {
        super(block);
        this.expr = expr;
        this.lower = lower;
        this.upper = upper;
        this.operator = operator;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}