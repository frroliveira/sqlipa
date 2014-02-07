package main.sqlipa.ast.stmt.pragma;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.expr.UnaryExpr;
import main.sqlipa.ast.visitor.VoidVisitor;

public class PragmaNumber extends PragmaValue {
    
    public UnaryExpr number;
    
    public PragmaNumber() {
        super();
    }
    
    public PragmaNumber(Block block, UnaryExpr number) {
        super(block);
        this.number = number;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}