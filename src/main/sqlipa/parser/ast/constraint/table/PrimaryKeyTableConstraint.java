package main.sqlipa.parser.ast.constraint.table;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.IndexedColumn;
import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class PrimaryKeyTableConstraint extends TableConstraint {
    
    private ConflictClause clause;

    private List<IndexedColumn> columns;

    public PrimaryKeyTableConstraint(int beginLine, int beginColumn,
            int endLine, int endColumn, ConstraintName name,
            ConflictClause clause) {
        this(beginLine, beginColumn, endLine, endColumn, name, clause,
                new LinkedList<IndexedColumn>());
    }
            
    public PrimaryKeyTableConstraint(int beginLine, int beginColumn,
            int endLine, int endColumn, ConstraintName name,
            ConflictClause clause, List<IndexedColumn> columns) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.clause = clause;
        this.columns = columns;
    }
    
    public ConflictClause getClause() {
        return clause;
    }
    
    public List<IndexedColumn> getColumns() {
        return columns;
    }
    
    public void setClause(ConflictClause clause) {
        this.clause = clause;
    }
    
    public void setColumns(List<IndexedColumn> columns) {
        this.columns = columns;
    }
    
    public void addColumn(IndexedColumn column) {
        columns.add(column);
    }
    
    public boolean removeColumn(IndexedColumn column) {
        return columns.remove(column);
    }
    
}