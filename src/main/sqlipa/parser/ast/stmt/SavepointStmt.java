package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.SavepointName;

public class SavepointStmt extends SqlStatement {
    
    private SavepointName savepoint;
    
    public SavepointStmt() {
        super();
    }
    
    public SavepointStmt(Block block, Explain explain,
            SavepointName savepoint) {
        this.savepoint = savepoint;
    }
    
    public SavepointName getSavepoint() {
        return savepoint;
    }
    
    public void setSavepoint(SavepointName savepoint) {
        this.savepoint = savepoint;
    }

}