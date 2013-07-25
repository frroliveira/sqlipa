package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public class ForeignKeySetting extends Node {

    public ForeignKeySetting() {
        super();
    }
    
    public ForeignKeySetting(Block block) {
        super(block);
    }
    
}