package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SelectExpr extends Expression {

    public SelectStmt select;
    
    public SelectExpr() {
        super();
    }
    
    public SelectExpr(Block block, SelectStmt select) {
        super(block);
        this.select = select;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}