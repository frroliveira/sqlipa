package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.stmt.SqlStatement;

public abstract class EventStmt extends SqlStatement {

    public EventStmt(Explain explain) {
        super(explain);
    }
    
    public EventStmt(int beginLine, int beginColumn, int endLine,
            int endColumn, Explain explain) {
        super(beginLine, beginColumn, endLine, endColumn, explain);
    }
    
}