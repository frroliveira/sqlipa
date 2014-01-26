package main.sqlipa.parser.ast;

public class ModuleArgument extends Node {
    
    private String arg;
    
    public ModuleArgument() {
        super();
    }
    
    public ModuleArgument(Block block, String arg) {
        super(block);
        this.arg = arg;
    }
    
    public String getArgument() {
        return arg;
    }
    
    public void setArgument(String arg) {
        this.arg = arg;
    }

}