package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.Name;

public class IndexedBy extends Node {
    
    private Name index;
    
    public IndexedBy() {
        super();
    }
    
    public IndexedBy(Block block, Name index) {
        super(block);
        this.index = index;
    }
    
    public Name getIndex() {
        return index;
    }
    
    public void setIndex(Name index) {
        this.index = index;
    }
    
}