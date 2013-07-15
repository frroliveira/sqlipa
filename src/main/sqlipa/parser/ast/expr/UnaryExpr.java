package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;

public class UnaryExpr extends Expression {

    public enum Operator {
        POSITIVE,
        NEGATIVE,
        BITWISE_NOT,
        LOGICAL_NOT
    }
    
    private Operator op;
    
    private Expression expr;
    
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
    
}