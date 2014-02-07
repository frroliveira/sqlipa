package main.sqlipa.ast.stmt.create;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;

public abstract class CreateTableStmt extends CreateStmt {

    public boolean hasTemporary;
    
    public CreateTableStmt() {
        super();
    }
    
    public CreateTableStmt(Block block, Explain explain, boolean hasIfNotExists, Name database,
            Name name, boolean hasTemporary) {
        super(block, explain, hasIfNotExists, database, name);
        this.hasTemporary = hasTemporary;
    }

}