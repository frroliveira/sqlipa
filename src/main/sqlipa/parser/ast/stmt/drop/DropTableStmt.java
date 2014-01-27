package main.sqlipa.parser.ast.stmt.drop;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public class DropTableStmt extends DropStmt {
    
    public DropTableStmt() {
        super();
    }
    
    public DropTableStmt(Block block, Explain explain, boolean hasIfExists, 
            DatabaseName db, Name name) {
        super(block, explain, hasIfExists, db, name);
    }

}