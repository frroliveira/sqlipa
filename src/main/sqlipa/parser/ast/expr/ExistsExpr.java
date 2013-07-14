package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class ExistsExpr extends Expression {

    private SelectStmt stmt;
    
    public ExistsExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, SelectStmt stmt) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.stmt = stmt;
    }
    
    public SelectStmt getStatement() {
        return stmt;
    }
    
    public void setStatement(SelectStmt stmt) {
        this.stmt = stmt;
    }
    
}