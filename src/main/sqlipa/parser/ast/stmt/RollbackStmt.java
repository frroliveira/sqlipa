package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class RollbackStmt extends SqlStatement {
    
    private Name savepoint;
    
    public RollbackStmt() {
        super();
    }
    
    public RollbackStmt(Block block, Explain explain, Name savepoint) {
        super(block, explain);
        this.savepoint = savepoint;
    }
    
    public Name getSavepoint() {
        return savepoint;
    }
    
    public void setSavepoint(Name savepoint) {
        this.savepoint = savepoint;
    }

}