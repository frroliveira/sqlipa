package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.IndexedBy;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class TableSrc extends SingleSrc {
    
    public Name database;
    
    public Name table;
    
    public Name alias;
    
    public IndexedBy indexedBy;

    public TableSrc() {
        super();
    }
    
    public TableSrc(Block block, Name database, Name table, Name alias, IndexedBy indexedBy) {
        super(block);
        this.database = database;
        this.table = table;
        this.alias = alias;
        this.indexedBy = indexedBy;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}