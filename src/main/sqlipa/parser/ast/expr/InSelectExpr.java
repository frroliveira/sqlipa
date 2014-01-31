package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class InSelectExpr extends InExpr {

    private SelectStmt stmt;
    
    public InSelectExpr() {
        super();
    }
    
    public InSelectExpr(Block block, Operator op, Expression expr,
            SelectStmt stmt) {
        super(block, op, expr);
        this.stmt = stmt;
    }
    
    public SelectStmt getStatement() {
        return stmt;
    }
    
    public void setStatement(SelectStmt stmt) {
        this.stmt = stmt;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}