package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.ColumnDef;
import main.sqlipa.parser.ast.constraint.table.TableConstraint;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public class CreateTableStmtWithColumns extends CreateTableStmt {

    private List<ColumnDef> columns;
    
    private List<TableConstraint> constraints;
    
    public CreateTableStmtWithColumns(int beginLine, int beginColumn,
            int endLine, int endColumn, Explain explain, boolean hasIfNotExists,
            DatabaseName db, Name struct, boolean hasTemp) {
        this(beginLine, beginColumn, endLine, endColumn, explain, 
                hasIfNotExists, db, struct, hasTemp, 
                new LinkedList<ColumnDef>(), new LinkedList<TableConstraint>());
    }
    
    public CreateTableStmtWithColumns(int beginLine, int beginColumn,
            int endLine, int endColumn, Explain explain, boolean hasIfNotExists,
            DatabaseName db, Name struct, boolean hasTemp,
            List<ColumnDef> columns, List<TableConstraint> constraints) {
        super(beginLine, beginColumn, endLine, endColumn, explain, 
                hasIfNotExists, db, struct, hasTemp);
        this.columns = columns;
        this.constraints = constraints;
    }
    
    public List<ColumnDef> getColumns() {
        return columns;
    }
    
    public List<TableConstraint> getConstraints() {
        return constraints;
    }
    
    public void setColumns(List<ColumnDef> columns) {
        this.columns = columns;
    }
    
    public void setConstraints(List<TableConstraint> constraints) {
        this.constraints = constraints;
    }
    
    public void addColumn(ColumnDef column) {
        columns.add(column);
    }
    
    public void addConstraint(TableConstraint constraint) {
        constraints.add(constraint);
    }
    
    public void removeColumn(ColumnDef column) {
        columns.remove(column);
    }
    
    public void removeConstraint(TableConstraint constraint) {
        constraints.remove(constraint);
    }

}