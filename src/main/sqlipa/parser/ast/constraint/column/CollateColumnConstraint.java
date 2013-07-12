package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.name.CollationName;
import main.sqlipa.parser.ast.name.ConstraintName;

public class CollateColumnConstraint extends ColumnConstraint {

    CollationName collation;
    
    public CollateColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name, CollationName collation) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
    public CollationName getCollation() {
        return collation;
    }
    
    public void setCollation(CollationName collation) {
        this.collation = collation;
    }
    
}