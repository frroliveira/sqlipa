package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.name.ConstraintName;

public abstract class Constraint extends Node {
    
    private ConstraintName name;

    public Constraint() {
        super();
    }
    
    public Constraint(Block block, ConstraintName name) {
        super(block);
        this.name = name;
    }

    public ConstraintName getName() {
        return name;
    }
    
    public void setName(ConstraintName name) {
        this.name = name;
    }
    
}