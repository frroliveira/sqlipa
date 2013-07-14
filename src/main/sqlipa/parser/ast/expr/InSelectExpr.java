package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class InSelectExpr extends InExpr {

    private SelectStmt stmt;
    
    public InSelectExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Operator op, Expression expr, SelectStmt stmt) {
        super(beginLine, beginColumn, endLine, endColumn, op, expr);
        this.stmt = stmt;
    }
    
    public SelectStmt getStatement() {
        return stmt;
    }
    
    public void setStatement(SelectStmt stmt) {
        this.stmt = stmt;
    }
    
}