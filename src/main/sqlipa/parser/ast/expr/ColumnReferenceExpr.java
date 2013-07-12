package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class ColumnReferenceExpr extends Expression {

    private DatabaseName db;
    
    private TableName tab;
    
    private ColumnName column;
    
    public ColumnReferenceExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, DatabaseName db, TableName tab, ColumnName column) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.db = db;
        this.tab = tab;
        this.column = column;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public ColumnName getColumn() {
        return column;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
    public void setColumn(ColumnName column) {
        this.column = column;
    }
    
}