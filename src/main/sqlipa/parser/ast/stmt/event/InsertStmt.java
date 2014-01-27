package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public abstract class InsertStmt extends EventStmt {
    
    public enum Type {
        INSERT,
        INSERT_OR_ROLLBACK,
        INSERT_OR_ABORT,
        INSERT_OR_REPLACE,
        INSERT_OR_FAIL,
        INSERT_OR_IGNORE,
        REPLACE
    }
    
    private Type type;
    
    private DatabaseName db;
    
    private TableName tab;
    
    public InsertStmt() {
        super();
    }
    
    public InsertStmt(Block block, Explain explain, Type type, DatabaseName db,
            TableName tab) {
        super(block, explain);
        this.type = type;
        this.db = db;
        this.tab = tab;
    }
    
    public Type getType() {
        return type;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }

}