package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ColumnAlias extends Alias {
    
    public ColumnAlias() {
        super();
    }
    
    public ColumnAlias(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public ColumnAlias(Block block, String name) {
        super(block, name);
    }
    
}