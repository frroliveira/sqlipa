package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.CollationName;
import main.sqlipa.parser.ast.name.ConstraintName;

public class CollateColumnConstraint extends ColumnConstraint {

    private CollationName collation;
    
    public CollateColumnConstraint() {
        super();
    }
    
    public CollateColumnConstraint(Block block, ConstraintName name,
            CollationName collation) {
        super(block, name);
        this.collation = collation;
    }
    
    public CollationName getCollation() {
        return collation;
    }
    
    public void setCollation(CollationName collation) {
        this.collation = collation;
    }
    
}