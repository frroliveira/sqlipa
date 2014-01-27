package main.sqlipa.parser.ast.stmt.drop;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public class DropTriggerStmt extends DropStmt {
    
    public DropTriggerStmt() {
        super();
    }
    
    public DropTriggerStmt(Block block, Explain explain, boolean hasIfExists, 
            DatabaseName db, Name name) {
        super(block, explain, hasIfExists, db, name);
    }

}