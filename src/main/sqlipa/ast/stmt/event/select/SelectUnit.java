package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class SelectUnit extends Node {
    
    public SelectUnit() {
        super();
    }
    
    public SelectUnit(Block block) {
        super(block);
    }

}