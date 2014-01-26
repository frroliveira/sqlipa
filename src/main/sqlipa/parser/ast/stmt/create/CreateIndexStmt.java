package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.IndexedColumn;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.name.TableName;

public class CreateIndexStmt extends CreateStmt {
    
    private boolean unique;
    
    private TableName tab;
    
    private List<IndexedColumn> columns;
    
    public CreateIndexStmt() {
        super();
        this.columns = new LinkedList<IndexedColumn>();
    }
    
    public CreateIndexStmt(Block block, Explain explain, boolean hasIfNotExists,
                DatabaseName db, Name name, boolean hasUnique, TableName tab,
                List<IndexedColumn> columns) {
        super(block, explain, hasIfNotExists, db, name);
        this.unique = hasUnique;
        this.tab = tab;
        this.columns = columns;
    }
    
    public boolean hasUnique() {
        return unique;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public List<IndexedColumn> getColumns() {
        return columns;
    }
    
    public void setUnique(boolean hasUnique) {
        this.unique = hasUnique;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
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