package main.sqlipa.parser.ast.literal;

import main.sqlipa.parser.ast.Node;

public class Literal extends Node {
    
    private String value;
    
    public Literal(int beginLine, int beginColumn, int endLine, int endColumn,
            String value) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
}