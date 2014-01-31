package main.sqlipa.parser.ast.constraint.table;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.IndexedColumn;
import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.visitor.VoidVisitor;
import main.sqlipa.parser.ast.Name;

public class UniqueTableConstraint extends TableConstraint {
    
    private ConflictClause clause;

    private List<IndexedColumn> columns;

    public UniqueTableConstraint() {
        super();
        this.columns = new LinkedList<IndexedColumn>();
    }
            
    public UniqueTableConstraint(Block block, Name name, ConflictClause clause,
            List<IndexedColumn> columns) {
        super(block, name);
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}