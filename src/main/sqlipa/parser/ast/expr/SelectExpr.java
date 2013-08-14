package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class SelectExpr extends Expression {

    private SelectStmt stmt;
    
    public SelectExpr() {
        super();
    }
    
    public SelectExpr(Block block, SelectStmt stmt) {
        super(block);
        this.stmt = stmt;
    }
    
    public SelectStmt getStatement() {
        return stmt;
    }
    
    public void setStatement(SelectStmt stmt) {
        this.stmt = stmt;
    }
    
}