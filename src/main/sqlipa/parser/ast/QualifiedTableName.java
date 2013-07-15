package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class QualifiedTableName extends Node {

    private DatabaseName db;
    
    private TableName tab;
    
    public QualifiedTableName(Block block, DatabaseName db, TableName tab) {
        super(block);
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