package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;

public abstract class SingleSrc extends JoinSrc {
    
    public SingleSrc() {
        super();
    }
    
    public SingleSrc(Block block) {
        super(block);
    }

}