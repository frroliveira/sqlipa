package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.IndexedBy;
import main.sqlipa.parser.ast.Name;

public class TableSrc extends SingleSrc {
    
    private Name database;
    
    private Name table;
    
    private Name alias;
    
    private IndexedBy indexed;

    public TableSrc() {
        super();
    }
    
    public TableSrc(Block block, Name database, Name table, Name alias,
            IndexedBy indexed) {
        super(block);
        this.database = database;
        this.table = table;
        this.alias = alias;
        this.indexed = indexed;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getTable() {
        return table;
    }
    
    public Name getAlias() {
        return alias;
    }
    
    public IndexedBy getIndexed() {
        return indexed;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }
    
    public void setAlias(Name alias) {
        this.alias = alias;
    }
    
    public void setIndexed(IndexedBy indexed) {
        this.indexed = indexed;
    }
    
}