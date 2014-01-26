package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.DatabaseName;

public class AttachStmt extends SqlStatement {
    
    private Expression expr;
    
    private DatabaseName db;
        
    public AttachStmt() {
        super();
    }
    
    public AttachStmt(Block block, Explain explain, Expression expr, 
            DatabaseName db) {
        super(block, explain);
        this.expr = expr;
        this.db = db;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }

}