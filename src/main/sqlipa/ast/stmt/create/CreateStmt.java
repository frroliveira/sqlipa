package main.sqlipa.ast.stmt.create;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.SqlStatement;

public abstract class CreateStmt extends SqlStatement {

    public boolean hasIfNotExists;
    
    public Name database;
    
    public Name name;
    
    public CreateStmt() {
        super();
    }
    
    public CreateStmt(Block block, Explain explain, boolean hasIfNotExists, Name database,
            Name name) {
        super(block, explain);
        this.hasIfNotExists = hasIfNotExists;
        this.database = database;
        this.name = name;
    }

}