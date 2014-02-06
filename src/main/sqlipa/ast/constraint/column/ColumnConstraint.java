package main.sqlipa.ast.constraint.column;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.Constraint;

public abstract class ColumnConstraint extends Constraint {

    public ColumnConstraint() {
        super();
    }
    
    public ColumnConstraint(Block block, Name name) {
        super(block, name);
    }

}