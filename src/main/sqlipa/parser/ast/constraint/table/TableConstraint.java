package main.sqlipa.parser.ast.constraint.table;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.Constraint;
import main.sqlipa.parser.ast.Name;

public abstract class TableConstraint extends Constraint {

    public TableConstraint() {
        super();
    }
    
    public TableConstraint(Block block, Name name) {
        super(block, name);
    }
    
}