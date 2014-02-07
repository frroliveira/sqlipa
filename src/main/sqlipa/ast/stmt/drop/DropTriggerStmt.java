package main.sqlipa.ast.stmt.drop;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class DropTriggerStmt extends DropStmt {
    
    public DropTriggerStmt() {
        super();
    }
    
    public DropTriggerStmt(Block block, Explain explain, boolean hasIfExists, Name database,
            Name name) {
        super(block, explain, hasIfExists, database, name);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}