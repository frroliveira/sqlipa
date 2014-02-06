package main.sqlipa.ast.stmt.pragma;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class PragmaValue extends Node {
    
    public PragmaValue() {
        super();
    }
    
    public PragmaValue(Block block) {
        super(block);
    }

}