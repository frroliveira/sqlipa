package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class CollationName extends Name {

    public CollationName() {
        super();
    }
    
    public CollationName(Block block, String name) {
        super(block, name);
    }
    
}