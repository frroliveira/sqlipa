package main.sqlipa.ast.constraint;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class DeferrableSetting extends ForeignKeySetting {

    public enum Type {
        DEFERRABLE,
        NOT_DEFERRABLE
    }
    
    public enum Mode {
        DEFERRED,
        IMMEDIATE
    }
    
    public Type type;
    
    public Mode mode;
    
    public DeferrableSetting() {
        super();
    }
    
    public DeferrableSetting(Block block, Type type, Mode mode) {
        super(block);
        this.type = type;
        this.mode = mode;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}