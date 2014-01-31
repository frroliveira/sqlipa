package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.visitor.VoidVisitor;
import main.sqlipa.parser.ast.Name;

public class PrimaryKeyColumnConstraint extends ColumnConstraint {

    public enum Order {
        ASC,
        DESC
    }

    private Order order;
    
    private ConflictClause clause;
    
    private boolean autoincrement;

    public PrimaryKeyColumnConstraint() {
        super();
    }
    
    public PrimaryKeyColumnConstraint(Order order, ConflictClause clause,
            boolean hasAutoincrement) {
        super();
        this.order = order;
        this.clause = clause;
        this.autoincrement = hasAutoincrement;
    }
    
    public PrimaryKeyColumnConstraint(Block block, Name name, Order order,
            ConflictClause clause, boolean hasAutoincrement) {
        super(block, name);
        this.order = order;
        this.clause = clause;
        this.autoincrement = hasAutoincrement;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public ConflictClause getClause() {
        return clause;
    }
    
    public boolean hasAutoincrement() {
        return autoincrement;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void setClause(ConflictClause clause) {
        this.clause = clause;
    }
    
    public void setAutoincrement(boolean hasAutoincrement) {
        this.autoincrement = hasAutoincrement;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}