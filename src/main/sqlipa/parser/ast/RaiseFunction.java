package main.sqlipa.parser.ast;

public class RaiseFunction extends Node {
    
    public enum Type {
        IGNORE,
        ROLLBACK,
        ABORT,
        FAIL
    }
    
    private Type type;
    
    private String error;
    
    public RaiseFunction(Block block, Type type, String error) {
        super(block);
        this.type = type;
        this.error = error;
    }
    
    public Type getType() {
        return type;
    }
    
    public String getError() {
        return error;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
}