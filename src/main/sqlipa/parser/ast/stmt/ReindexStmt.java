package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class ReindexStmt extends SqlStatement {
    
    private Name first;
    
    private Name second;
    
    public ReindexStmt() {
        super();
    }
    
    public ReindexStmt(Block block, Explain explain, Name first, Name second) {
        super(block, explain);
        this.first = first;
        this.second = second;
    }
    
    public Name getFirst() {
        return first;
    }
    
    public Name getSecond() {
        return second;
    }
    
    public void setFirst(Name first) {
        this.first = first;
    }
    
    public void setSecond(Name second) {
        this.second = second;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}