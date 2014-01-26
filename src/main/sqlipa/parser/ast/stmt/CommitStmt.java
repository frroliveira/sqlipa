package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;

public class CommitStmt extends SqlStatement {
    
    public CommitStmt() {
        super();
    }
    
    public CommitStmt(Block block, Explain explain) {
        super(block, explain);
    }

}