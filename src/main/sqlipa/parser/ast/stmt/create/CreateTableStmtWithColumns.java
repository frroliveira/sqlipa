package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.ColumnDef;
import main.sqlipa.parser.ast.constraint.table.TableConstraint;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public class CreateTableStmtWithColumns extends CreateTableStmt {

    private List<ColumnDef> columns;
    
    private List<TableConstraint> constraints;
    
    public CreateTableStmtWithColumns() {
        super();
        this.columns = new LinkedList<ColumnDef>();
        this.constraints = new LinkedList<TableConstraint>();
    }
    
    public CreateTableStmtWithColumns(Block block, Explain explain,
            boolean hasIfNotExists, DatabaseName db, Name struct, 
            boolean hasTemp, List<ColumnDef> columns, 
            List<TableConstraint> constraints) {
        super(block, explain, hasIfNotExists, db, struct, hasTemp);
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
    
    public boolean removeColumn(ColumnDef column) {
        return columns.remove(column);
    }
    
    public boolean removeConstraint(TableConstraint constraint) {
        return constraints.remove(constraint);
    }

}