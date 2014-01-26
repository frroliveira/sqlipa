package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.SavepointName;

public class RollbackStmt extends SqlStatement {
    
    private SavepointName savepoint;
    
    public RollbackStmt() {
        super();
    }
    
    public RollbackStmt(Block block, Explain explain, SavepointName savepoint) {
        super(block, explain);
        this.savepoint = savepoint;
    }
    
    public SavepointName getSavepoint() {
        return savepoint;
    }
    
    public void setSavepoint(SavepointName savepoint) {
        this.savepoint = savepoint;
    }

}