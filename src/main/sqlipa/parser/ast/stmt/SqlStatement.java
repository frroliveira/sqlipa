package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Node;

public abstract class SqlStatement extends Node {
    
    public enum Explain {
        NORMAL,
        PLAN
    }
    
    private Explain explain;

    public SqlStatement(Explain explain) {
        this.explain = explain;
    }
    
    public SqlStatement(int beginLine, int beginColumn, int endLine, 
            int endColumn, Explain explain) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.explain = explain;
    }
    
    public Explain getExplain() {
        return explain;
    }
    
}