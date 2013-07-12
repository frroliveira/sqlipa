package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.name.TypeName;

public class CastExpr extends Expression {

    private Expression expr;
    
    private TypeName type;
    
    public CastExpr(int beginLine, int beginColumn, int endLine, int endColumn,
            Expression expr, TypeName type) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.expr = expr;
        this.type = type;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public TypeName getType() {
        return type;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setType(TypeName type) {
        this.type = type;
    }
    
}