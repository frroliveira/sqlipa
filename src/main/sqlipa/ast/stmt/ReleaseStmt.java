package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ReleaseStmt extends SqlStatement {
    
    public Name savepoint;
    
    public boolean hasSavepoint;
    
    public ReleaseStmt() {
        super();
    }
    
    public ReleaseStmt(Block block, Explain explain, Name savepoint, boolean hasSavepoint) {
        super(block, explain);
        this.savepoint = savepoint;
        this.hasSavepoint = hasSavepoint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}