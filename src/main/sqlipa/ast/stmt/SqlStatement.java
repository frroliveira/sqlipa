package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class SqlStatement extends Node {
    
    public enum Explain {
        NORMAL,
        PLAN
    }
    
    private Explain explain;

    public SqlStatement() {
        super();
    }
    
    public SqlStatement(Block block, Explain explain) {
        super(block);
        this.explain = explain;
    }
    
    public Explain getExplain() {
        return explain;
    }
    
    public void setExplain(Explain explain) {
        this.explain = explain;
    }

}