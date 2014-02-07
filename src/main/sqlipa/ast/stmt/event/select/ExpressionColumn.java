package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ExpressionColumn extends ResultColumn {

    public Expression expr;
    
    public ExpressionColumn() {
        super();
    }
    
    public ExpressionColumn(Block block, Expression expr) {
        super(block);
        this.expr = expr;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}