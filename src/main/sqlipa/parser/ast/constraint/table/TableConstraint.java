package main.sqlipa.parser.ast.constraint.table;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.Constraint;
import main.sqlipa.parser.ast.name.ConstraintName;

public abstract class TableConstraint extends Constraint {

    public TableConstraint(Block block, ConstraintName name) {
        super(block, name);
    }
    
}