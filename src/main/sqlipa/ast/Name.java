package main.sqlipa.ast;

import main.sqlipa.ast.visitor.VoidVisitor;

public class Name extends Node {
    
    public String name;
    
    public Name() {
        super();
    }
    
    public Name(Name name) {
        super(name);
        this.name = new String(name.name);
    }
    
    public Name(Block block, String name) {
        super(block);
        this.name = name;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}