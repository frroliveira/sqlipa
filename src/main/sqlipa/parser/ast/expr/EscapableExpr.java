package main.sqlipa.parser.ast.expr;

public class EscapableExpr extends Expression {

    public enum Operator {
        LIKE,
        GLOB,
        REGEXP,
        MATCH,
        NOT_LIKE,
        NOT_GLOB,
        NOT_REGEXP,
        NOT_MATCH
    }
    
    private Expression left;
    
    private Expression right;
    
    private Expression escape;
    
    private Operator op;
    
    public EscapableExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Expression left, Expression right, Expression escape,
            Operator op) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.left = left;
        this.right = right;
        this.escape = escape;
        this.op = op;
    }
    
    public Expression getLeft() {
        return left;
    }
    
    public Expression getRight() {
        return right;
    }
    
    public Expression getEscape() {
        return escape;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public void setLeft(Expression left) {
        this.left = left;
    }
    
    public void setRight(Expression right) {
        this.right = right;
    }
    
    public void setEscape(Expression escape) {
        this.escape = escape;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
}