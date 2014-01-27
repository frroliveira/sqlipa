package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.expr.Expression;

public class DeleteStmt extends EventStmt {
    
    private QualifiedTableName qualifiedTab;
    
    private Expression where;
    
    public DeleteStmt() {
        super();
    }
    
    public DeleteStmt(Block block, Explain explain,
            QualifiedTableName qualifiedTab, Expression where) {
        super(block, explain);
        this.qualifiedTab = qualifiedTab;
        this.where = where;
    }
    
    public QualifiedTableName getQualifiedTable() {
        return qualifiedTab;
    }
    
    public Expression getWhere() {
        return where;
    }
    
    public void setQualifiedTable(QualifiedTableName qualifiedTab) {
        this.qualifiedTab = qualifiedTab;
    }
    
    public void setWhere(Expression where) {
        this.where = where;
    }

}