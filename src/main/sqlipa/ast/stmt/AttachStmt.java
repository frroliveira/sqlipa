package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class AttachStmt extends SqlStatement {
    
    private Expression expr;
    
    private Name database;
        
    public AttachStmt() {
        super();
    }
    
    public AttachStmt(Block block, Explain explain, Expression expr, 
            Name database) {
        super(block, explain);
        this.expr = expr;
        this.database = database;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}