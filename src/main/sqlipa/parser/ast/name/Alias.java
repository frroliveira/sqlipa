package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class Alias extends Name {
    
    public Alias() {
        super();
    }
    
    public Alias(Block block, String name) {
        super(block, name);
    }
    
}