package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.literal.Literal;

public class LiteralExpr extends Expression {

    private Literal literal;
    
    public LiteralExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Literal literal) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.literal = literal;
    }
    
    public Literal getLiteral() {
        return literal;
    }
    
    public void setLiteral(Literal literal) {
        this.literal = literal;
    }
    
}