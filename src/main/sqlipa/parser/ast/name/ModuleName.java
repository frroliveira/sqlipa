package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ModuleName extends Name {
    
    public ModuleName() {
        super();
    }
    
    public ModuleName(Block block, String name) {
        super(block, name);
    }

}