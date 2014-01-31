package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

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
    
    private Operator op;
    
    private Expression expr;
    
    public UnaryExpr() {
        super();
    }
    
    public UnaryExpr(Block block, Operator op, Expression expr) {
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}