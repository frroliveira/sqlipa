package main.sqlipa.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.IndexedColumn;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateIndexStmt extends CreateStmt {
    
    private boolean unique;
    
    private Name table;
    
    private List<IndexedColumn> columns;
    
    public CreateIndexStmt() {
        super();
        this.columns = new LinkedList<IndexedColumn>();
    }
    
    public CreateIndexStmt(Block block, Explain explain, boolean hasIfNotExists,
                Name db, Name name, boolean hasUnique, Name table,
                List<IndexedColumn> columns) {
        super(block, explain, hasIfNotExists, db, name);
        this.unique = hasUnique;
        this.table = table;
        this.columns = columns;
    }
    
    public boolean hasUnique() {
        return unique;
    }
    
    public Name getTable() {
        return table;
    }
    
    public List<IndexedColumn> getColumns() {
        return columns;
    }
    
    public void setUnique(boolean hasUnique) {
        this.unique = hasUnique;
    }
    
    public void setTable(Name table) {
        this.table = table;
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