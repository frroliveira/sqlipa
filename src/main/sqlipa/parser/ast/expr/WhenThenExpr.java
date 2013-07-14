package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Node;

public class WhenThenExpr extends Node {
    
    private Expression when;
    
    private Expression then;
    
    public WhenThenExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Expression when, Expression then) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.when = when;
        this.then = then;
    }
    
    public Expression getWhen() {
        return when;
    }
    
    public Expression getThen() {
        return then;
    }
    
    public void setWhen(Expression when) {
        this.when = when;
    }
    
    public void setThen(Expression then) {
        this.then = then;
    }
    
}