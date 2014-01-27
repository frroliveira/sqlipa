package main.sqlipa.parser.ast.stmt.event.update;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.stmt.event.EventConstraint;
import main.sqlipa.parser.ast.stmt.event.EventStmt;

public class UpdateStmt extends EventStmt {
    
    public enum Type {
        UPDATE,
        UPDATE_OR_ROLLBACK,
        UPDATE_OR_ABORT,
        UPDATE_OR_REPLACE,
        UPDATE_OR_FAIL,
        UPDATE_OR_IGNORE
    }
    
    private Type type;
    
    private QualifiedTableName qualifiedTab;
    
    private List<ColumnAssign> assigns;
    
    private Expression where;
    
    private EventConstraint constraint;

    public UpdateStmt() {
        super();
        this.assigns = new LinkedList<ColumnAssign>();
    }
    
    public UpdateStmt(Block block, Explain explain, Type type,
            QualifiedTableName qualifiedTab, List<ColumnAssign> assigns,
            Expression where, EventConstraint constraint) {
        super(block, explain);
        this.type = type;
        this.qualifiedTab = qualifiedTab;
        this.assigns = assigns;
        this.where = where;
        this.constraint = constraint;
    }
    
    public Type getType() {
        return type;
    }
    
    public QualifiedTableName getQualifiedTable() {
        return qualifiedTab;
    }
    
    public List<ColumnAssign> getAssignments() {
        return assigns;
    }
    
    public Expression getWhere() {
        return where;
    }
    
    public EventConstraint getConstraint() {
        return constraint;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public void setQualifiedTab(QualifiedTableName qualifiedTab) {
        this.qualifiedTab = qualifiedTab;
    }
    
    public void setAssignments(List<ColumnAssign> assigns) {
        this.assigns = assigns;
    }
    
    public void setWhere(Expression where) {
        this.where = where;
    }
    
    public void setConstraint(EventConstraint constraint) {
        this.constraint = constraint;
    }
    
    public void addAssignment(ColumnAssign assign) {
        assigns.add(assign);
    }
    
    public boolean removeAssignment(ColumnAssign assign) {
        return assigns.remove(assign);
    }

}