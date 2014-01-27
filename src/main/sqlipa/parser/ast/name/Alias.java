package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class Alias extends Name {
    
    public Alias() {
        super();
    }

    public Alias(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public Alias(Block block, String name) {
        super(block, name);
    }
    
}