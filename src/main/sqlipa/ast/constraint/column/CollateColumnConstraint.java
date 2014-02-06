package main.sqlipa.ast.constraint.column;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

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