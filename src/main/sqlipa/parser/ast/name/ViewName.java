package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ViewName extends Name {

    public ViewName() {
        super();
    }
    
    public ViewName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public ViewName(Block block, String name) {
        super(block, name);
    }
    
}