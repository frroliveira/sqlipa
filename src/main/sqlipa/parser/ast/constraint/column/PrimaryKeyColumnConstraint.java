package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class PrimaryKeyColumnConstraint extends ColumnConstraint {

    public enum Order {
        ASC,
        DESC
    }

    Order order;
    
    ConflictClause clause;
    
    boolean autoincrement;

    public PrimaryKeyColumnConstraint(int beginLine, int beginColumn,
            int endLine, int endColumn, ConstraintName name, Order order, 
            ConflictClause clause, boolean hasAutoincrement) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.order = order;
        this.clause = clause;
        this.autoincrement = hasAutoincrement;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public ConflictClause getConflictClause() {
        return clause;
    }
    
    public boolean hasAutoincrement() {
        return autoincrement;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void setConflictClause(ConflictClause clause) {
        this.clause = clause;
    }
    
    public void setAutoincrement(boolean hasAutoincrement) {
        this.autoincrement = hasAutoincrement;
    }
    
}