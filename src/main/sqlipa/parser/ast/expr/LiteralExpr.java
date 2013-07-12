package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.LiteralValue;

public class LiteralExpr extends Expression {

    private LiteralValue literal;
    
    public LiteralExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, LiteralValue literal) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.literal = literal;
    }
    
    public LiteralValue getLiteral() {
        return literal;
    }
    
    public void setLiteral(LiteralValue literal) {
        this.literal = literal;
    }
    
}