package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.CollationName;

public class CollateExpr extends Expression {

    private Expression expr;
    
    private CollationName collation;
    
    public CollateExpr() {
        super();
    }
    
    public CollateExpr(Block block, Expression expr, CollationName collation) {
        super(block);
        this.expr = expr;
        this.collation = collation;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public CollationName getCollation() {
        return collation;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setCollation(CollationName collation) {
        this.collation = collation;
    }
    
}