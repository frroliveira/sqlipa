package main.sqlipa.parser.ast.stmt.drop;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.stmt.SqlStatement;

public abstract class DropStmt extends SqlStatement {
    
    private boolean ifExists;
    
    private DatabaseName db;
    
    private Name name;
    
    public DropStmt() {
        super();
    }
    
    public DropStmt(Block block, Explain explain, boolean hasIfExists,
            DatabaseName db, Name name) {
        super(block, explain);
        this.ifExists = hasIfExists;
        this.db = db;
        this.name = name;
    }
    
    public boolean hasIfExists() {
        return ifExists;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public Name getName() {
        return name;
    }
    
    public void setIfExists(boolean hasIfExists) {
        this.ifExists = hasIfExists;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setName(Name name) {
        this.name = name;
    }

}