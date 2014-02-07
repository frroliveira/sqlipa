package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InSelectExpr extends InExpr {

    public SelectStmt select;
    
    public InSelectExpr() {
        super();
    }
    
    public InSelectExpr(Block block, Operator operator, Expression expr, SelectStmt select) {
        super(block, operator, expr);
        this.select = select;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}