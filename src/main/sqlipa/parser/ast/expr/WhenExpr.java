package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class WhenExpr extends Node {
    
    private Expression when;
    
    private Expression then;
    
    public WhenExpr() {
        super();
    }
    
    public WhenExpr(Block block, Expression when, Expression then) {
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}