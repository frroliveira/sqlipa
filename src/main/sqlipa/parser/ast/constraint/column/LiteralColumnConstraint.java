package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.LiteralValue;
import main.sqlipa.parser.ast.name.ConstraintName;

public class LiteralColumnConstraint extends DefaultColumnConstraint {

    private LiteralValue literal;
    
    public LiteralColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name, LiteralValue literal) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.literal = literal;
    }
    
    public LiteralValue getLiteral() {
        return literal;
    }
    
    public void setLiteral(LiteralValue literal) {
        this.literal = literal;
    }

}