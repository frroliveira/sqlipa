package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.expr.Expression;

public class DeleteStmt extends EventStmt {
    
    private QualifiedTableName qualifiedTable;
    
    private Expression where;
    
    private EventConstraint constraint;

    public DeleteStmt() {
        super();
    }
    
    public DeleteStmt(Block block, Explain explain,
            QualifiedTableName qualifiedTable, Expression where,
            EventConstraint constraint) {
        super(block, explain);
        this.qualifiedTable = qualifiedTable;
        this.where = where;
        this.constraint = constraint;
    }
    
    public QualifiedTableName getQualifiedTable() {
        return qualifiedTable;
    }
    
    public Expression getWhere() {
        return where;
    }
    
    public EventConstraint getConstraint() {
        return constraint;
    }
    
    public void setQualifiedTable(QualifiedTableName qualifiedTable) {
        this.qualifiedTable = qualifiedTable;
    }
    
    public void setWhere(Expression where) {
        this.where = where;
    }
    
    public void setConstraint(EventConstraint constraint) {
        this.constraint = constraint;
    }

}