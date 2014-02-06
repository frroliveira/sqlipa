package main.sqlipa.ast.constraint.table;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.Constraint;

public abstract class TableConstraint extends Constraint {

    public TableConstraint() {
        super();
    }
    
    public TableConstraint(Block block, Name name) {
        super(block, name);
    }

}