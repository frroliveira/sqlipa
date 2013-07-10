package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.ColumnDef;
import main.sqlipa.parser.ast.constraint.TableConstraint;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public class CreateTableStmtWithColumns extends CreateTableStmt {

    private List<ColumnDef> columns;
    private List<TableConstraint> constraints;
    
    public CreateTableStmtWithColumns(int beginLine, int beginColumn,
            int endLine, int endColumn, Explain explain, boolean hasIfNotExists,
            DatabaseName db, Name struct, boolean temp) {
        super(beginLine, beginColumn, endLine, endColumn, explain, 
                hasIfNotExists, db, struct, temp);
        columns = new LinkedList<ColumnDef>();
        constraints = new LinkedList<TableConstraint>();
    }
    
    public List<ColumnDef> getColumns() {
        return columns;
    }
    
    public List<TableConstraint> getConstraints() {
        return constraints;
    }
    
    public void addColumn(ColumnDef column) {
        columns.add(column);
    }
    
    public void addConstraint(TableConstraint constraint) {
        constraints.add(constraint);
    }

}