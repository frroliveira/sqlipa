package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.ConstraintName;

public class CheckColumnConstraint extends ColumnConstraint {

    Expression expr;
    
    public CheckColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name, Expression expr) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.expr = expr;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
}