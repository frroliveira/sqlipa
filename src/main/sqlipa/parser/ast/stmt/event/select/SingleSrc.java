package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;

public abstract class SingleSrc extends JoinSrc {
    
    public SingleSrc() {
        super();
    }
    
    public SingleSrc(Block block) {
        super(block);
    }

}