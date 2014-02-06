package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class AnalyzeStmt extends SqlStatement {
    
    private Name first;

    private Name second;    
    
    public AnalyzeStmt() {
        super();
    }
    
    public AnalyzeStmt(Block block, Explain explain, Name first, Name second) {
        super(block, explain);
        this.first = first;
        this.second = second;
    }
    
    public Name getFirstName() {
        return first;
    }
    
    public Name getSecondName() {
        return second;
    }
    
    public void setFirstName(Name first) {
        this.first = first;
    }
    
    public void setSecondName(Name second) {
        this.second = second;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}