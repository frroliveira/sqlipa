package main.sqlipa.parser.ast.literal;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

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