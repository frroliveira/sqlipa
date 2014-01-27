package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;

public class BeginStmt extends SqlStatement {
    
    public enum Type {
        DEFERRED,
        IMMEDIATE,
        EXCLUSIVE
    }
    
    private Type type;

    public BeginStmt() {
        super();
    }
    
    public BeginStmt(Block block, Explain explain, Type type) {
        super(block, explain);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }

}