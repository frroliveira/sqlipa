package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class IndexName extends Name {

    public IndexName(String name) {
        super(name);
    }
    
    public IndexName(Block block, String name) {
        super(block, name);
    }
    
}