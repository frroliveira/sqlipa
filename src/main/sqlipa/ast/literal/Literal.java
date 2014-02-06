package main.sqlipa.ast.literal;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.visitor.VoidVisitor;

public class Literal extends Node {
    
    private String value;
    
    public Literal(Block block, String value) {
        super(block);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}