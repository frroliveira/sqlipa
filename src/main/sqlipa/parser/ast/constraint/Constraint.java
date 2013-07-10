package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.name.ConstraintName;

public abstract class Constraint extends Node {
    
    private ConstraintName name;
    
    public Constraint(ConstraintName name) {
        this.name = name;
    }
    
    public Constraint(int beginLine, int beginColumn, int endLine, 
            int endColumn, ConstraintName name) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.name = name;
    }
    
    public ConstraintName getName() {
        return name;
    }
    
    public void setName(ConstraintName name) {
        this.name = name;
    }
    
}