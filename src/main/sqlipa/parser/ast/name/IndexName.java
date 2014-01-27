package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class IndexName extends Name {

    public IndexName() {
        super();
    }
    
    public IndexName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public IndexName(Block block, String name) {
        super(block, name);
    }
    
}