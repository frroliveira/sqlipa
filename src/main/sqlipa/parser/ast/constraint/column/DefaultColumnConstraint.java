package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.ConstraintName;

public abstract class DefaultColumnConstraint extends ColumnConstraint {

    public DefaultColumnConstraint() {
        super();
    }
    
    public DefaultColumnConstraint(Block block, ConstraintName name) {
        super(block, name);
    }
    
}