package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class DatabaseName extends Name {

    public DatabaseName() {
        super();
    }
    
    public DatabaseName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public DatabaseName(Block block, String name) {
        super(block, name);
    }
    
}