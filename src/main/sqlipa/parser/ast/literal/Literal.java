package main.sqlipa.parser.ast.literal;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

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
    
}