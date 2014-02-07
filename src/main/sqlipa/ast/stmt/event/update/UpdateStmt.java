package main.sqlipa.ast.stmt.event.update;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.QualifiedTableName;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.stmt.event.EventConstraint;
import main.sqlipa.ast.stmt.event.EventStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class UpdateStmt extends EventStmt {
    
    public enum Type {
        UPDATE,
        UPDATE_OR_ROLLBACK,
        UPDATE_OR_ABORT,
        UPDATE_OR_REPLACE,
        UPDATE_OR_FAIL,
        UPDATE_OR_IGNORE
    }
    
    public Type type;
    
    public QualifiedTableName qualifiedTable;
    
    public List<ColumnAssignment> assignments;
    
    public Expression where;
    
    public EventConstraint constraint;

    public UpdateStmt() {
        super();
    }
    
    public UpdateStmt(Block block, Explain explain, Type type, QualifiedTableName qualifiedTable,
            List<ColumnAssignment> assignments, Expression where, EventConstraint constraint) {
        super(block, explain);
        this.type = type;
        this.qualifiedTable = qualifiedTable;
        this.assignments = assignments;
        this.where = where;
        this.constraint = constraint;
    }
    
    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}