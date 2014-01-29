package main.sqlipa.parser.ast;


public class Name extends Node {
    
    private String name;
    
    public Name() {
    }
    
    public Name(Name name) {
        super(name);
        this.name = new String(name.getName());
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