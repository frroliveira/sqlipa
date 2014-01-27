package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class TableName extends Name {

    public TableName() {
        super();
    }
    
    public TableName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public TableName(Block block, String name) {
        super(block, name);
    }
    
}