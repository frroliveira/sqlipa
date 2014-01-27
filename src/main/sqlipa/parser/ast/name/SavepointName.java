package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class SavepointName extends Name {
    
    public SavepointName() {
        super();
    }
    
    public SavepointName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public SavepointName(Block block, String name) {
        super(block, name);
    }

}