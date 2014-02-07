package main.sqlipa.ast.stmt.create;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.stmt.event.EventStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateTriggerStmt extends CreateStmt {
    
    public enum Time {
        BEFORE,
        AFTER,
        INSTEAD_OF
    }
    
    public enum Event {
        DELETE,
        INSERT,
        UPDATE
    }
    
    public boolean hasTemporary;
    
    public boolean hasForEachRow;
    
    public Time time;
    
    public Event event;
    
    public List<Name> columns;
    
    public Name table;
    
    public Expression when;
    
    public List<EventStmt> stmts;
    
    public CreateTriggerStmt() {
        super();
    }
    
    public CreateTriggerStmt(Block block, Explain explain, boolean hasIfNotExists, Name database,
            Name name, boolean hasTemporary, boolean hasForEachRow, Time time, Event event,
            List<Name> columns, Name table, Expression when, List<EventStmt> stmts) {
        super(block, explain, hasIfNotExists, database, name);
        this.hasTemporary = hasTemporary;
        this.hasForEachRow = hasForEachRow;
        this.time = time;
        this.event = event;
        this.columns = columns;
        this.table = table;
        this.when = when;
        this.stmts = stmts;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}