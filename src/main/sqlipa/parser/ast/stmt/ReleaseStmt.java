package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class ReleaseStmt extends SqlStatement {
    
    private Name savepoint;
    
    public ReleaseStmt() {
        super();
    }
    
    public ReleaseStmt(Block block, Explain explain, Name savepoint) {
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