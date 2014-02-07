package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class BeginStmt extends SqlStatement {
    
    public enum Type {
        DEFERRED,
        IMMEDIATE,
        EXCLUSIVE
    }
    
    public Type type;

    public BeginStmt() {
        super();
    }
    
    public BeginStmt(Block block, Explain explain, Type type) {
        super(block, explain);
        this.type = type;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}