package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.stmt.event.EventConstraint;
import main.sqlipa.parser.ast.stmt.event.EventStmt;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class SelectStmt extends EventStmt {

    private SelectUnit unit;

    private EventConstraint constraint;
    
    public SelectStmt() {
        super();
    }
    
    public SelectStmt(Block block, Explain explain, SelectUnit unit,
            EventConstraint constraint) {
        super(block, explain);
        this.unit = unit;
        this.constraint = constraint;
    }
    
    public SelectUnit getUnit() {
        return unit;
    }
    
    public EventConstraint getConstraint() {
        return constraint;
    }
    
    public void setUnit(SelectUnit unit) {
        this.unit = unit;
    }
    
    public void setConstraint(EventConstraint constraint) {
        this.constraint = constraint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}