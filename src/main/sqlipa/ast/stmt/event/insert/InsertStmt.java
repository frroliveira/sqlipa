package main.sqlipa.ast.stmt.event.insert;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.event.EventStmt;

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
    
    public Type type;
    
    public Name database;
    
    public Name table;
    
    public InsertStmt() {
        super();
    }
    
    public InsertStmt(Block block, Explain explain, Type type, Name database, Name table) {
        super(block, explain);
        this.type = type;
        this.database = database;
        this.table = table;
    }

}