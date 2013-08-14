package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class ColumnExpr extends Expression {

    private DatabaseName db;
    
    private TableName tab;
    
    private ColumnName column;
    
    public ColumnExpr() {
        super();
    }
    
    public ColumnExpr(Block block, DatabaseName db, TableName tab,
            ColumnName column) {
        super(block);
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