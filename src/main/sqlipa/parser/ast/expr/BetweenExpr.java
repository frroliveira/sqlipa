package main.sqlipa.parser.ast.expr;

public class BetweenExpr extends Expression {

    public enum Operator {
        BETWEEN,
        NOT_BETWEEN
    }
    
    private Expression expr;
    
    private Expression lower;
    
    private Expression upper;
    
    private Operator op;
    
    public BetweenExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Expression expr, Expression lower, Expression upper,
            Operator op) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.expr = expr;
        this.lower = lower;
        this.upper = upper;
        this.op = op;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public Expression getLower() {
        return lower;
    }
    
    public Expression getUpper() {
        return upper;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setLower(Expression lower) {
        this.lower = lower;
    }
    
    public void setUpper(Expression upper) {
        this.upper = upper;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
}