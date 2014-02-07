package main.sqlipa.ast.expr;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InSetExpr extends InExpr {

    public List<Expression> set;
    
    public InSetExpr() {
        super();
    }

    public InSetExpr(Block block, Operator operator, Expression expr, List<Expression> set) {
        super(block, operator, expr);
        this.set = set;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}