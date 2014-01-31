package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}