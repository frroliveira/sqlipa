package main.sqlipa.ast.constraint;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.Node;

public abstract class Constraint extends Node {
    
    public Name name;

    public Constraint() {
        super();
    }
    
    public Constraint(Block block, Name name) {
        super(block);
        this.name = name;
    }

}