package main.sqlipa.parser.ast.stmt.drop;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class DropTriggerStmt extends DropStmt {
    
    public DropTriggerStmt() {
        super();
    }
    
    public DropTriggerStmt(Block block, Explain explain, boolean hasIfExists, 
            Name db, Name name) {
        super(block, explain, hasIfExists, db, name);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}