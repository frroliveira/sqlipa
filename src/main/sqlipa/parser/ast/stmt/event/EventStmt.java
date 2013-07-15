package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.stmt.SqlStatement;

public abstract class EventStmt extends SqlStatement {

    public EventStmt(Explain explain) {
        super(explain);
    }
    
    public EventStmt(Block block, Explain explain) {
        super(block, explain);
    }
    
}