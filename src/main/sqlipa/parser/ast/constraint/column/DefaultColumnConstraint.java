package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.Name;

public class DefaultColumnConstraint extends ColumnConstraint {

    private Expression expr;
    
    public DefaultColumnConstraint() {
        super();
    }
    
    public DefaultColumnConstraint(Block block, Name name, Expression expr) {
        super(block, name);
        this.expr = expr;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
}