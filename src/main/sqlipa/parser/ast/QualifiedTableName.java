package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class QualifiedTableName extends Node {

    private DatabaseName db;
    
    private TableName tab;
    
    private IndexedBy indexed;
    
    public QualifiedTableName() {
        super();
    }
    
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
    
    public IndexedBy getIndexed() {
        return indexed;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
    public void setIndexed(IndexedBy indexed) {
        this.indexed = indexed;
    }
    
}