package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.literal.Literal;
import main.sqlipa.ast.visitor.VoidVisitor;

public class LiteralExpr extends Expression {

    public Literal literal;
    
    public LiteralExpr() {
        super();
    }
    
    public LiteralExpr(Block block, Literal literal) {
        super(block);
        this.literal = literal;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}