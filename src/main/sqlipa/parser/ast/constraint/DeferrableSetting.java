package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;

public class DeferrableSetting extends ForeignKeySetting {

    public enum Type {
        DEFERRABLE,
        NOT_DEFERRABLE
    }
    
    public enum Mode {
        DEFERRED,
        IMMEDIATE
    }
    
    private Type type;
    
    private Mode mode;
    
    public DeferrableSetting() {
        super();
    }
    
    public DeferrableSetting(Block block, Type type, Mode mode) {
        super(block);
        this.type = type;
        this.mode = mode;
    }
    
    public Type getType() {
        return type;
    }
    
    public Mode getMode() {
        return mode;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    
}