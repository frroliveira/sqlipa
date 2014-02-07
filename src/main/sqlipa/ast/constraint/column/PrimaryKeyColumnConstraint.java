package main.sqlipa.ast.constraint.column;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.ConflictClause;
import main.sqlipa.ast.visitor.VoidVisitor;

public class PrimaryKeyColumnConstraint extends ColumnConstraint {

    public enum Order {
        ASC,
        DESC
    }

    public Order order;
    
    public ConflictClause clause;
    
    public boolean hasAutoincrement;

    public PrimaryKeyColumnConstraint() {
        super();
    }
    
    public PrimaryKeyColumnConstraint(Block block, Name name, Order order, ConflictClause clause,
            boolean hasAutoincrement) {
        super(block, name);
        this.order = order;
        this.clause = clause;
        this.hasAutoincrement = hasAutoincrement;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}