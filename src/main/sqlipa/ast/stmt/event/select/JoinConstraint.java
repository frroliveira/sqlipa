package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class JoinConstraint extends Node {
    
    public JoinConstraint() {
        super();
    }

    public JoinConstraint(Block block) {
        super(block);
    }

}