package main.sqlipa.parser.ast.constraint.table;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.constraint.ForeignKeyClause;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.ConstraintName;

public class ForeignKeyTableConstraint extends TableConstraint {

    private ForeignKeyClause clause;
    
    private List<ColumnName> columns;
    
    public ForeignKeyTableConstraint(int beginLine, int beginColumn,
            int endLine, int endColumn, ConstraintName name,
            ForeignKeyClause clause) {
        this(beginLine, beginColumn, endLine, endColumn, name, clause,
                new LinkedList<ColumnName>());
    }

    public ForeignKeyTableConstraint(int beginLine, int beginColumn,
            int endLine, int endColumn, ConstraintName name,
            ForeignKeyClause clause, List<ColumnName> columns) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.clause = clause;
        this.columns = columns;
    }
    
    public ForeignKeyClause getClause() {
        return clause;
    }
    
    public List<ColumnName> getColumns() {
        return columns;
    }
    
    public void setClause(ForeignKeyClause clause) {
        this.clause = clause;
    }
    
    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }
    
    public void addColumn(ColumnName column) {
        columns.add(column);
    }
    
    public boolean removeColumn(ColumnName column) {
        return columns.remove(column);
    }
    
}