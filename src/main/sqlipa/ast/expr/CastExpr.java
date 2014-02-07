package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.TypeName;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CastExpr extends Expression {

    public Expression expr;
    
    public TypeName type;
    
    public CastExpr() {
        super();
    }
    
    public CastExpr(Block block, Expression expr, TypeName type) {
        super(block);
        this.expr = expr;
        this.type = type;
    }


    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}