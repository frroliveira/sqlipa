package main.sqlipa.ast;

import main.sqlipa.ast.visitor.VoidVisitor;

public class ModuleArgument extends Node {
    
    public String argument;
    
    public ModuleArgument() {
        super();
    }
    
    public ModuleArgument(Block block, String argument) {
        super(block);
        this.argument = argument;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}