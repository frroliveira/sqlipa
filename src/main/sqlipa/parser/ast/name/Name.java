package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public class Name extends Node {
    
    private String name;
    
    public Name() {
    }
    
    public Name(Block block, String name) {
        super(block);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}