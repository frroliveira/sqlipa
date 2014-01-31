package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class ExpressionColumn extends ResultColumn {

    private Expression expr;
    
    public ExpressionColumn() {
        super();
    }
    
    public ExpressionColumn(Block block, Expression expr) {
        super(block);
        this.expr = expr;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}