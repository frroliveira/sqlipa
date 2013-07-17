package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public abstract class SqlStatement extends Node {
    
    public enum Explain {
        NORMAL,
        PLAN
    }
    
    private Explain explain;

    public SqlStatement() {
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