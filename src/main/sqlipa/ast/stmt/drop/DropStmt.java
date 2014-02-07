package main.sqlipa.ast.stmt.drop;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.SqlStatement;

public abstract class DropStmt extends SqlStatement {
    
    public boolean hasIfExists;
    
    public Name database;
    
    public Name name;
    
    public DropStmt() {
        super();
    }
    
    public DropStmt(Block block, Explain explain, boolean hasIfExists, Name database, Name name) {
        super(block, explain);
        this.hasIfExists = hasIfExists;
        this.database = database;
        this.name = name;
    }

}