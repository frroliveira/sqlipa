package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class DetachStmt extends SqlStatement {
    
    public Name database;
    
    public boolean hasDatabase;
    
    public DetachStmt() {
        super();
    }
    
    public DetachStmt(Block block, Explain explain, Name database, boolean hasDatabase) {
        super(block, explain);
        this.database = database;
        this.hasDatabase = hasDatabase;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}