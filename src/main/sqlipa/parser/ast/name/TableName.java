package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class TableName extends Name {

    public TableName(String name) {
        super(name);
    }
    
    public TableName(Block block, String name) {
        super(block, name);
    }
    
}