package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.ConstraintName;

public class ExpressionColumnConstraint extends ColumnConstraint {

    private Expression expr;
    
    public ExpressionColumnConstraint(Block block, ConstraintName name,
            Expression expr) {
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