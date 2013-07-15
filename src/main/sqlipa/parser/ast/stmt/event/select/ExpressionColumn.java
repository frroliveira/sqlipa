package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;

public class ExpressionColumn extends ResultColumn {

    private Expression expr;
    
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
    
}