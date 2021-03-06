package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.visitor.VoidVisitor;

public class WhenExpr extends Node {
    
    public Expression when;
    
    public Expression then;
    
    public WhenExpr() {
        super();
    }
    
    public WhenExpr(Block block, Expression when, Expression then) {
        super(block);
        this.when = when;
        this.then = then;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}