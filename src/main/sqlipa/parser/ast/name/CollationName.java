package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class CollationName extends Name {

    public CollationName() {
        super();
    }
    
    public CollationName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public CollationName(Block block, String name) {
        super(block, name);
    }
    
}