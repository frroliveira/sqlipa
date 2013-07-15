package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public class WhenThenExpr extends Node {
    
    private Expression when;
    
    private Expression then;
    
    public WhenThenExpr(Block block, Expression when, Expression then) {
        super(block);
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