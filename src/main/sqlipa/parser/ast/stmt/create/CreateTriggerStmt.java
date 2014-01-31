package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.stmt.event.EventStmt;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

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
    
    private boolean temp;
    
    private boolean forEachRow;
    
    private Time time;
    
    private Event event;
    
    private List<Name> columns;
    
    private Name table;
    
    private Expression when;
    
    private List<EventStmt> stmts;
    
    public CreateTriggerStmt() {
        super();
        columns = new LinkedList<Name>();
        stmts = new LinkedList<EventStmt>();
    }
    
    public CreateTriggerStmt(Block block, Explain explain,
            boolean hasIfNotExists, Name db, Name name, boolean hasTemp,
            boolean hasForEachRow, Time time, Event event, List<Name> columns,
            Name table, Expression when, List<EventStmt> stmts) {
        super(block, explain, hasIfNotExists, db, name);
        this.temp = hasTemp;
        this.forEachRow = hasForEachRow;
        this.time = time;
        this.event = event;
        this.columns = columns;
        this.table = table;
        this.when = when;
        this.stmts = stmts;
    }
    
    public boolean hasTemporary() {
        return temp;
    }
    
    public boolean hasForEachRow() {
        return forEachRow;
    }
    
    public Time getTime() {
        return time;
    }
    
    public Event getEvent() {
        return event;
    }
    
    public List<Name> getColumns() {
        return columns;
    }
    
    public Name getTable() {
        return table;
    }
    
    public Expression getWhen() {
        return when;
    }
    
    public List<EventStmt> getStatements() {
        return stmts;
    }
    
    public void setTemporary(boolean hasTemp) {
        this.temp = hasTemp;
    }
    
    public void setForEachRow(boolean hasForEachRow) {
        this.forEachRow = hasForEachRow;
    }
    
    public void setTime(Time time) {
        this.time = time;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    public void setColumns(List<Name> columns) {
        this.columns = columns;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }
    
    public void setWhen(Expression when) {
        this.when = when;
    }
    
    public void setStatements(List<EventStmt> stmts) {
        this.stmts = stmts;
    }
    
    public void addColumn(Name column) {
        columns.add(column);
    }
    
    public void addStatement(EventStmt stmt) {
        stmts.add(stmt);
    }
    
    public boolean removeColumn(Name column) {
        return columns.remove(column);
    }
    
    public boolean removeStatement(EventStmt stmt) {
        return stmts.remove(stmt);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}