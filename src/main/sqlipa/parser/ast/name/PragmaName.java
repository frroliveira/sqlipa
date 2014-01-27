package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class PragmaName extends Name {

    public PragmaName() {
        super();
    }
    
    public PragmaName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public PragmaName(Block block, String name) {
        super(block, name);
    }
    
}