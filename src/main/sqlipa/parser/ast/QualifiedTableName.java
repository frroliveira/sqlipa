package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class QualifiedTableName extends Node {

    private DatabaseName db;
    
    private TableName tab;
    
    public QualifiedTableName(int beginLine, int beginColumn, int endLine,
            int endColumn, DatabaseName db, TableName tab) {
        super(beginLine, beginColumn, endLine, endColumn);
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