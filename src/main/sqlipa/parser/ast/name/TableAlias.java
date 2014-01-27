package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class TableAlias extends Alias {

    public TableAlias() {
        super();
    }
    
    public TableAlias(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public TableAlias(Block block, String name) {
        super(block, name);
    }
    
}