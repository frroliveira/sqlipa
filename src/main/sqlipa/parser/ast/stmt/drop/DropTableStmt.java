package main.sqlipa.parser.ast.stmt.drop;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class DropTableStmt extends DropStmt {
    
    public DropTableStmt() {
        super();
    }
    
    public DropTableStmt(Block block, Explain explain, boolean hasIfExists, 
            Name db, Name name) {
        super(block, explain, hasIfExists, db, name);
    }

}