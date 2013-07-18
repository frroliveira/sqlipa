package main.sqlipa.parser.ast.constraint.table;

import main.sqlipa.parser.ast.expr.Expression;

public class CheckTableConstraint extends TableConstraint {

    private Expression expr;
    
    public CheckTableConstraint(Expression expr) {
        super();
        this.expr = expr;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
}