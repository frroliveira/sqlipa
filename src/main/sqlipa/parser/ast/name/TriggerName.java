package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class TriggerName extends Name {

    public TriggerName() {
        super();
    }
    
    public TriggerName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public TriggerName(Block block, String name) {
        super(block, name);
    }
    
}