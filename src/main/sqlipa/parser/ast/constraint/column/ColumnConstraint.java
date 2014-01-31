package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.Constraint;
import main.sqlipa.parser.ast.visitor.VoidVisitor;
import main.sqlipa.parser.ast.Name;

public abstract class ColumnConstraint extends Constraint {

    public ColumnConstraint() {
        super();
    }
    
    public ColumnConstraint(Block block, Name name) {
        super(block, name);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}