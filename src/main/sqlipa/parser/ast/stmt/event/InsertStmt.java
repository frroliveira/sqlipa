package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

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
    
    private Name database;
    
    private Name table;
    
    public InsertStmt() {
        super();
    }
    
    public InsertStmt(Block block, Explain explain, Type type, Name database,
            Name table) {
        super(block, explain);
        this.type = type;
        this.database = database;
        this.table = table;
    }
    
    public Type getType() {
        return type;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getTable() {
        return table;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }

}