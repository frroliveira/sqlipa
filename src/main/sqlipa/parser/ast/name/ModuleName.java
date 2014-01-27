package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ModuleName extends Name {
    
    public ModuleName() {
        super();
    }
    
    public ModuleName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public ModuleName(Block block, String name) {
        super(block, name);
    }

}