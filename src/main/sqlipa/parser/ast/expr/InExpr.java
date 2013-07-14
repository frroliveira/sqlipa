package main.sqlipa.parser.ast.expr;

public class InExpr extends Expression {

    public enum Operator {
        IN,
        NOT_IN
    }
    
    private Operator op;
    
    private Expression expr;
    
    public InExpr(int beginLine, int beginColumn, int endLine, int endColumn,
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