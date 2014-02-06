package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class ResultColumn extends Node {
    
    public ResultColumn() {
        super();
    }
    
    public ResultColumn(Block block) {
        super(block);
    }

}