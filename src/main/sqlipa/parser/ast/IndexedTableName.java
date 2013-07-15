package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.IndexName;
import main.sqlipa.parser.ast.name.TableName;

public class IndexedTableName extends QualifiedTableName {

    private IndexName ind;
    
    public IndexedTableName(Block block, DatabaseName db, TableName tab, IndexName ind) {
        super(block, db, tab);
        this.ind = ind;
    }
    
    public IndexName getIndex() {
        return ind;
    }
    
    public void setIndex(IndexName ind) {
        this.ind = ind;
    }
    
}