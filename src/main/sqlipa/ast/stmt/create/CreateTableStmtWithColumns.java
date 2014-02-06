package main.sqlipa.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.ColumnDef;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.table.TableConstraint;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateTableStmtWithColumns extends CreateTableStmt {

    private List<ColumnDef> columns;
    
    private List<TableConstraint> constraints;
    
    public CreateTableStmtWithColumns() {
        super();
        this.columns = new LinkedList<ColumnDef>();
        this.constraints = new LinkedList<TableConstraint>();
    }
    
    public CreateTableStmtWithColumns(CreateTableStmt stmt) {
        super(stmt, stmt.getExplain(), stmt.hasIfNotExists(),
                new Name(stmt.getDatabase()),
                new Name(stmt.getName()), stmt.hasTemporary());
        this.columns = new LinkedList<ColumnDef>();
        this.constraints = new LinkedList<TableConstraint>();
    }
    
    public CreateTableStmtWithColumns(Block block, Explain explain,
            boolean hasIfNotExists, Name db, Name name, boolean hasTemp,
            List<ColumnDef> columns, List<TableConstraint> constraints) {
        super(block, explain, hasIfNotExists, db, name, hasTemp);
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}