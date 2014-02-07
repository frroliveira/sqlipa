package main.sqlipa.ast;

import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class IndexedBy extends Node {
    
    public Name index;
    
    public IndexedBy() {
        super();
    }
    
    public IndexedBy(Block block, Name index) {
        super(block);
        this.index = index;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}