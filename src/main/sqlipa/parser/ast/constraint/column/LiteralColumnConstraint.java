package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.literal.Literal;
import main.sqlipa.parser.ast.name.ConstraintName;

public class LiteralColumnConstraint extends DefaultColumnConstraint {

    private Literal literal;
    
    public LiteralColumnConstraint(Block block, ConstraintName name,
            Literal literal) {
        super(block, name);
        this.literal = literal;
    }
    
    public Literal getLiteral() {
        return literal;
    }
    
    public void setLiteral(Literal literal) {
        this.literal = literal;
    }

}