package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ColumnName extends Name {

    public ColumnName() {
        super();
    }
    
    public ColumnName(Block block, String name) {
        super(block, name);
    }

}