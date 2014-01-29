package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class SavepointStmt extends SqlStatement {
    
    private Name savepoint;
    
    public SavepointStmt() {
        super();
    }
    
    public SavepointStmt(Block block, Explain explain,
            Name savepoint) {
        this.savepoint = savepoint;
    }
    
    public Name getSavepoint() {
        return savepoint;
    }
    
    public void setSavepoint(Name savepoint) {
        this.savepoint = savepoint;
    }

}