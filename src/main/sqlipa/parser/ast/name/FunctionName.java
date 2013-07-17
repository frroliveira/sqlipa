package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class FunctionName extends Name {

    public FunctionName() {
        super();
    }
    
    public FunctionName(Block block, String name) {
        super(block, name);
    }
    
}