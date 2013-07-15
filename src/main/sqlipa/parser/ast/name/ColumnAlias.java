package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ColumnAlias extends Alias {

    public ColumnAlias(String name) {
        super(name);
    }
    
    public ColumnAlias(Block block, String name) {
        super(block, name);
    }
    
}