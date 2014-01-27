package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class FunctionName extends Name {

    public FunctionName() {
        super();
    }
    
    public FunctionName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public FunctionName(Block block, String name) {
        super(block, name);
    }
    
}