package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.expr.Expression;

public class ExpressionColumn extends ResultColumn {

    private Expression expr;
    
    public ExpressionColumn(int beginLine, int beginColumn, int endLine,
            int endColumn, Expression expr) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.expr = expr;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
}