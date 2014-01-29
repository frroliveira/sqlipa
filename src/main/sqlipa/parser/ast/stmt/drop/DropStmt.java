package main.sqlipa.parser.ast.stmt.drop;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.stmt.SqlStatement;

public abstract class DropStmt extends SqlStatement {
    
    private boolean ifExists;
    
    private Name database;
    
    private Name name;
    
    public DropStmt() {
        super();
    }
    
    public DropStmt(Block block, Explain explain, boolean hasIfExists,
            Name database, Name name) {
        super(block, explain);
        this.ifExists = hasIfExists;
        this.database = database;
        this.name = name;
    }
    
    public boolean hasIfExists() {
        return ifExists;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getName() {
        return name;
    }
    
    public void setIfExists(boolean hasIfExists) {
        this.ifExists = hasIfExists;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setName(Name name) {
        this.name = name;
    }

}