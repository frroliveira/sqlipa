package main.sqlipa.ast.stmt.event.select;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class JoinConstraintUsing extends JoinConstraint {

    public List<Name> columns;
    
    public JoinConstraintUsing() {
        super();
    }

    public JoinConstraintUsing(Block block, List<Name> columns) {
        super(block);
        this.columns = columns;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}