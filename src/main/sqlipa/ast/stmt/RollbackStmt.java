package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class RollbackStmt extends SqlStatement {
    
    public Name savepoint;
    
    public RollbackStmt() {
        super();
    }
    
    public RollbackStmt(Block block, Explain explain, Name savepoint) {
        super(block, explain);
        this.savepoint = savepoint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}