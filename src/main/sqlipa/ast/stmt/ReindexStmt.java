package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ReindexStmt extends SqlStatement {
    
    public Name first;
    
    public Name second;
    
    public ReindexStmt() {
        super();
    }
    
    public ReindexStmt(Block block, Explain explain, Name first, Name second) {
        super(block, explain);
        this.first = first;
        this.second = second;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}