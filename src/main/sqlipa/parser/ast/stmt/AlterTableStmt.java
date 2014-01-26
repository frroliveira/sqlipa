package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class AlterTableStmt extends SqlStatement {

    private DatabaseName db;
    
    private TableName tab;
    
    public AlterTableStmt() {
        super();
    }
    
    public AlterTableStmt(Block block, Explain explain, DatabaseName db, TableName tab) {
        super(block, explain);
        this.db = db;
        this.tab = tab;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
}