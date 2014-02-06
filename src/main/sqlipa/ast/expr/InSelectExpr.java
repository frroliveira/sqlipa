package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InSelectExpr extends InExpr {

    private SelectStmt select;
    
    public InSelectExpr() {
        super();
    }
    
    public InSelectExpr(Block block, Operator op, Expression expr,
            SelectStmt select) {
        super(block, op, expr);
        this.select = select;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}