package main.sqlipa.parser.ast.stmt.pragma;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public abstract class PragmaValue extends Node {
    
    public PragmaValue() {
        super();
    }
    
    public PragmaValue(Block block) {
        super(block);
    }

}