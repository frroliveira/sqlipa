package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.IndexedColumn;
import main.sqlipa.parser.ast.Name;

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

}