package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.IndexName;

public class IndexedBy extends Node {
    
    private IndexName ind;
    
    public IndexedBy() {
        super();
    }
    
    public IndexedBy(Block block, IndexName ind) {
        super(block);
        this.ind = ind;
    }
    
    public IndexName getIndex() {
        return ind;
    }
    
    public void setIndex(IndexName ind) {
        this.ind = ind;
    }
    
}