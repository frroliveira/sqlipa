package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class UnaryExpr extends Expression {

    public enum Operator {
        POSITIVE,
        NEGATIVE,
        BIT_NOT,
        LOGICAL_NOT,
        EXISTS,
        IS_NULL,
        NOT_NULL
    }
    
    public Operator operator;
    
    public Expression expr;
    
    public UnaryExpr() {
        super();
    }
    
    public UnaryExpr(Block block, Operator operator, Expression expr) {
        super(block);
        this.operator = operator;
        this.expr = expr;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}