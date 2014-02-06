package main.sqlipa.ast.stmt.drop;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class DropViewStmt extends DropStmt {
    
    public DropViewStmt() {
        super();
    }
    
    public DropViewStmt(Block block, Explain explain, boolean hasIfExists, 
            Name db, Name name) {
        super(block, explain, hasIfExists, db, name);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}