package main.sqlipa.parser.ast.stmt.drop;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class DropIndexStmt extends DropStmt {
    
    public DropIndexStmt() {
        super();
    }
    
    public DropIndexStmt(Block block, Explain explain, boolean hasIfExists, 
            Name db, Name name) {
        super(block, explain, hasIfExists, db, name);
    }

}