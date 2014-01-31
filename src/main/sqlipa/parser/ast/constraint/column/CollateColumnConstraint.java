package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class CollateColumnConstraint extends ColumnConstraint {

    private Name collation;
    
    public CollateColumnConstraint() {
        super();
    }
    
    public CollateColumnConstraint(Block block, Name name, Name collation) {
        super(block, name);
        this.collation = collation;
    }
    
    public Name getCollation() {
        return collation;
    }
    
    public void setCollation(Name collation) {
        this.collation = collation;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}