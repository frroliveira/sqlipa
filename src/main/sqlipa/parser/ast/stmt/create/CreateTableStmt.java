package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public abstract class CreateTableStmt extends CreateStmt {

    private boolean temp;
    
    public CreateTableStmt() {
        super();
    }
    
    public CreateTableStmt(Block block, Explain explain, boolean hasIfNotExists,
            Name db, Name name, boolean hasTemp) {
        super(block, explain, hasIfNotExists, db, name);
        this.temp = hasTemp;
    }

    public boolean hasTemporary() {
        return temp;
    }
    
    public void setTemporary(boolean hasTemp) {
        this.temp = hasTemp;
    }

}