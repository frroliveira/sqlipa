package main.sqlipa.ast.stmt.event;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.stmt.SqlStatement;

public abstract class EventStmt extends SqlStatement {

    public EventStmt() {
        super();
    }
    
    public EventStmt(Block block, Explain explain) {
        super(block, explain);
    }

}