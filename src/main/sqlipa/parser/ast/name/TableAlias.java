package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class TableAlias extends Alias {

    public TableAlias(String name) {
        super(name);
    }
    
    public TableAlias(Block block, String name) {
        super(block, name);
    }
    
}