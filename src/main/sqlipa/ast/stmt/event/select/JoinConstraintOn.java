package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class JoinConstraintOn extends JoinConstraint {

    public Expression expr;
    
    public JoinConstraintOn() {
        super();
    }
    
    public JoinConstraintOn(Block block, Expression expr) {
        super(block);
        this.expr = expr;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}