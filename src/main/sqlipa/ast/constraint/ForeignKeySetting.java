package main.sqlipa.ast.constraint;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class ForeignKeySetting extends Node {

    public ForeignKeySetting() {
        super();
    }
    
    public ForeignKeySetting(Block block) {
        super(block);
    }

}