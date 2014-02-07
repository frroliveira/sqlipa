package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.stmt.event.EventConstraint;
import main.sqlipa.ast.stmt.event.EventStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SelectStmt extends EventStmt {

    public SelectUnit unit;

    public EventConstraint constraint;
    
    public SelectStmt() {
        super();
    }
    
    public SelectStmt(Block block, Explain explain, SelectUnit unit, EventConstraint constraint) {
        super(block, explain);
        this.unit = unit;
        this.constraint = constraint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}