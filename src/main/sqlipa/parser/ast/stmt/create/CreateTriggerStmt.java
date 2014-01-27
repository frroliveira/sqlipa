package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.name.TableName;
import main.sqlipa.parser.ast.stmt.event.EventStmt;

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
    
    private List<ColumnName> columns;
    
    private TableName tab;
    
    private Expression when;
    
    private List<EventStmt> stmts;
    
    public CreateTriggerStmt() {
        super();
        columns = new LinkedList<ColumnName>();
        stmts = new LinkedList<EventStmt>();
    }
    
    public CreateTriggerStmt(Block block, Explain explain,
            boolean hasIfNotExists, DatabaseName db, Name name, boolean hasTemp,
            boolean hasForEachRow, Time time, Event event,
            List<ColumnName> columns, TableName tab, Expression when,
            List<EventStmt> stmts) {
        super(block, explain, hasIfNotExists, db, name);
        this.temp = hasTemp;
        this.forEachRow = hasForEachRow;
        this.time = time;
        this.event = event;
        this.columns = columns;
        this.tab = tab;
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
    
    public List<ColumnName> getColumns() {
        return columns;
    }
    
    public TableName getTable() {
        return tab;
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
    
    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
    public void setWhen(Expression when) {
        this.when = when;
    }
    
    public void setStatements(List<EventStmt> stmts) {
        this.stmts = stmts;
    }
    
    public void addColumn(ColumnName column) {
        columns.add(column);
    }
    
    public void addStatement(EventStmt stmt) {
        stmts.add(stmt);
    }
    
    public boolean removeColumn(ColumnName column) {
        return columns.remove(column);
    }
    
    public boolean removeStatement(EventStmt stmt) {
        return stmts.remove(stmt);
    }

}