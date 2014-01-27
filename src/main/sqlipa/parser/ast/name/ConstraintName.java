package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;

public class ConstraintName extends Name {

    public ConstraintName() {
        super();
    }
    
    public ConstraintName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
    
    public ConstraintName(Block block, String name) {
        super(block, name);
    }

}