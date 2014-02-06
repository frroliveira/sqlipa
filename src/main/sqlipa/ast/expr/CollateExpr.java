package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CollateExpr extends Expression {

    private Expression expr;
    
    private Name collation;
    
    public CollateExpr() {
        super();
    }
    
    public CollateExpr(Block block, Expression expr, Name collation) {
        super(block);
        this.expr = expr;
        this.collation = collation;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public Name getCollation() {
        return collation;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setCollation(Name collation) {
        this.collation = collation;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}