package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.IndexedBy;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableAlias;
import main.sqlipa.parser.ast.name.TableName;

public class TableSrc extends SingleSrc {
    
    private DatabaseName db;
    
    private TableName tab;
    
    private TableAlias alias;
    
    private IndexedBy indexed;

    public TableSrc() {
        super();
    }
    
    public TableSrc(Block block, DatabaseName db, TableName tab, 
            TableAlias alias, IndexedBy indexed) {
        super(block);
        this.db = db;
        this.tab = tab;
        this.alias = alias;
        this.indexed = indexed;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public TableAlias getAlias() {
        return alias;
    }
    
    public IndexedBy getIndexed() {
        return indexed;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
    public void setAlias(TableAlias alias) {
        this.alias = alias;
    }
    
    public void setIndexed(IndexedBy indexed) {
        this.indexed = indexed;
    }
    
}