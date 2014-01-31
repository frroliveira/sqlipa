package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class InExpr extends Expression {

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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}