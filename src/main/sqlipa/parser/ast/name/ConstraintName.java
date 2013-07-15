package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ConstraintName extends Name {

    public ConstraintName(String name) {
        super(name);
    }
    
    public ConstraintName(Block block, String name) {
        super(block, name);
    }

}