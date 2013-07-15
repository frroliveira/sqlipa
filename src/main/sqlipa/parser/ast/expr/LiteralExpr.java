package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.literal.Literal;

public class LiteralExpr extends Expression {

    private Literal literal;
    
    public LiteralExpr(Block block, Literal literal) {
        super(block);
        this.literal = literal;
    }
    
    public Literal getLiteral() {
        return literal;
    }
    
    public void setLiteral(Literal literal) {
        this.literal = literal;
    }
    
}