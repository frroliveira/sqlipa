package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public abstract class JoinSrc extends Node {
    
    public JoinSrc() {
        super();
    }
    
    public JoinSrc(Block block) {
        super(block);
    }
    
}