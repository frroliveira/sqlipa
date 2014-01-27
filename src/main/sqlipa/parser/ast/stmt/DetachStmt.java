package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;

public class DetachStmt extends SqlStatement {
    
    private DatabaseName db;
    
    public DetachStmt() {
        super();
    }
    
    public DetachStmt(Block block, Explain explain, DatabaseName db) {
        super(block, explain);
        this.db = db;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }

}