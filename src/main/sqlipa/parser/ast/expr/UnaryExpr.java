package main.sqlipa.parser.ast.expr;

public class UnaryExpr extends Expression {

    public enum Operator {
        POSITIVE,
        NEGATIVE,
        BITWISE_NOT,
        LOGICAL_NOT
    }
    
    private Operator op;
    
    private Expression expr;
    
    public UnaryExpr(int beginLine, int beginColumn, int endLine, int endColumn,
            Operator op, Expression expr) {
        super(beginLine, beginColumn, endLine, endColumn);
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