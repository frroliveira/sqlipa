package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Node;

public class Name extends Node {
    
    private String name;
    
    public Name(String name) {
        this.name = name;
    }
    
    public Name(int beginLine, int beginColumn, int endLine, int endColumn, 
            String name) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}