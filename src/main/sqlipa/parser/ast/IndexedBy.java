package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}