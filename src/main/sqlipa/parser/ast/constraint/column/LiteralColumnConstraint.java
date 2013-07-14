package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.literal.Literal;
import main.sqlipa.parser.ast.name.ConstraintName;

public class LiteralColumnConstraint extends DefaultColumnConstraint {

    private Literal literal;
    
    public LiteralColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name, Literal literal) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.literal = literal;
    }
    
    public Literal getLiteral() {
        return literal;
    }
    
    public void setLiteral(Literal literal) {
        this.literal = literal;
    }

}