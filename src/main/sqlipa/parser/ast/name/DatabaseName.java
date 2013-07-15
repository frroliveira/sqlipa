package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class DatabaseName extends Name {

    public DatabaseName(String name) {
        super(name);
    }
    
    public DatabaseName(Block block, String name) {
        super(block, name);
    }
    
}