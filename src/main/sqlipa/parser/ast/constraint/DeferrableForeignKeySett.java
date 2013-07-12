package main.sqlipa.parser.ast.constraint;

public class DeferrableForeignKeySett extends ForeignKeySetting {

    public enum Mode {
        DEFERRED,
        IMMEDIATE
    }
    
    Mode mode;
    
    public DeferrableForeignKeySett(int beginLine, int beginColumn,
            int endLine, int endColumn, boolean isDeferrable, Mode mode) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.mode = mode;
    }
    
    public Mode getMode() {
        return mode;
    }
    
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    
}