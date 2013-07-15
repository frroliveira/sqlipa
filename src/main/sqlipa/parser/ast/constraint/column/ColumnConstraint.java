package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.Constraint;
import main.sqlipa.parser.ast.name.ConstraintName;

public class ColumnConstraint extends Constraint {

    public ColumnConstraint(Block block, ConstraintName name) {
        super(block, name);
    }
    
}