package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.IndexName;
import main.sqlipa.parser.ast.name.TableName;

public class IndexedTableName extends QualifiedTableName {

    private IndexName ind;
    
    public IndexedTableName(int beginLine, int beginColumn, int endLine,
            int endColumn, DatabaseName db, TableName tab, IndexName ind) {
        super(beginLine, beginColumn, endLine, endColumn, db, tab);
        this.ind = ind;
    }
    
    public IndexName getIndex() {
        return ind;
    }
    
    public void setIndex(IndexName ind) {
        this.ind = ind;
    }
    
}