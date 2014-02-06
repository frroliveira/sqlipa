package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class JoinSrc extends Node {
    
    public JoinSrc() {
        super();
    }
    
    public JoinSrc(Block block) {
        super(block);
    }

}