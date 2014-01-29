package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.Name;

public abstract class Constraint extends Node {
    
    private Name name;

    public Constraint() {
        super();
    }
    
    public Constraint(Block block, Name name) {
        super(block);
        this.name = name;
    }

    public Name getName() {
        return name;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
}