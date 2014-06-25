package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class AttachStmt extends SqlStatement {
    
    public Expression expr;
    
    public Name database;
    
    public boolean hasDatabase;
        
    public AttachStmt() {
        super();
    }
    
    public AttachStmt(Block block, Explain explain, Expression expr, Name database,
    		boolean hasDatabase) {
        super(block, explain);
        this.expr = expr;
        this.database = database;
        this.hasDatabase = hasDatabase;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}