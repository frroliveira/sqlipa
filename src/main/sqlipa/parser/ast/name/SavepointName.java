package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class SavepointName extends Name {
    
    public SavepointName() {
        super();
    }
    
    public SavepointName(Block block, String name) {
        super(block, name);
    }

}