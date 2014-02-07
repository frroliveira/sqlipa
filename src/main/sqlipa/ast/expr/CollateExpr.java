package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CollateExpr extends Expression {

    public Expression expr;
    
    public Name collation;
    
    public CollateExpr() {
        super();
    }
    
    public CollateExpr(Block block, Expression expr, Name collation) {
        super(block);
        this.expr = expr;
        this.collation = collation;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}