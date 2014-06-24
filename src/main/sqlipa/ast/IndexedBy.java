package main.sqlipa.ast;

import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class IndexedBy extends Node {
    
    public Name index;
    
    public boolean notIndexed;
    
    public IndexedBy() {
        super();
    }
    
    public IndexedBy(Block block, Name index, boolean notIndexed) {
        super(block);
        this.index = index;
        this.notIndexed = notIndexed;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}