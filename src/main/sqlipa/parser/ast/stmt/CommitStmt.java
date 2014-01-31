package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class CommitStmt extends SqlStatement {
    
    public CommitStmt() {
        super();
    }
    
    public CommitStmt(Block block, Explain explain) {
        super(block, explain);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}