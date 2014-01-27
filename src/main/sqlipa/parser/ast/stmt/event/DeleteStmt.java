package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.expr.Expression;

public class DeleteStmt extends EventStmt {
    
    private QualifiedTableName qualifiedTab;
    
    private Expression where;
    
    private EventConstraint constraint;

    public DeleteStmt() {
        super();
    }
    
    public DeleteStmt(Block block, Explain explain,
            QualifiedTableName qualifiedTab, Expression where,
            EventConstraint constraint) {
        super(block, explain);
        this.qualifiedTab = qualifiedTab;
        this.where = where;
        this.constraint = constraint;
    }
    
    public QualifiedTableName getQualifiedTable() {
        return qualifiedTab;
    }
    
    public Expression getWhere() {
        return where;
    }
    
    public EventConstraint getConstraint() {
        return constraint;
    }
    
    public void setQualifiedTable(QualifiedTableName qualifiedTab) {
        this.qualifiedTab = qualifiedTab;
    }
    
    public void setWhere(Expression where) {
        this.where = where;
    }
    
    public void setConstraint(EventConstraint constraint) {
        this.constraint = constraint;
    }

}