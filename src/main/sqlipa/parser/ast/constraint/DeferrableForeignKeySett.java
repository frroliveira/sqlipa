package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;

public class DeferrableForeignKeySett extends ForeignKeySetting {

    public enum Mode {
        DEFERRED,
        IMMEDIATE
    }
    
    Mode mode;
    
    public DeferrableForeignKeySett(Block block, boolean isDeferrable,
            Mode mode) {
        super(block);
        this.mode = mode;
    }
    
    public Mode getMode() {
        return mode;
    }
    
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    
}