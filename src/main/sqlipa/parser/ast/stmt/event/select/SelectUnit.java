package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public abstract class SelectUnit extends Node {
    
    public SelectUnit() {
        super();
    }
    
    public SelectUnit(Block block) {
        super(block);
    }
    
}