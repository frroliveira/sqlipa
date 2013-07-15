package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class CollationName extends Name {

    public CollationName(String name) {
        super(name);
    }
    
    public CollationName(Block block, String name) {
        super(block, name);
    }
    
}