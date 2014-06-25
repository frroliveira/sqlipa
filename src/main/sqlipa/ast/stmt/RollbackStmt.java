package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class RollbackStmt extends SqlStatement {
    
    public Name savepoint;
    
    public boolean hasTransaction;
    
    public boolean hasSavepoint;
    
    public RollbackStmt() {
        super();
    }
    
    public RollbackStmt(Block block, Explain explain, Name savepoint, boolean hasTransaction,
    		boolean hasSavepoint) {
        super(block, explain);
        this.savepoint = savepoint;
        this.hasTransaction = hasTransaction;
        this.hasSavepoint = hasSavepoint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}