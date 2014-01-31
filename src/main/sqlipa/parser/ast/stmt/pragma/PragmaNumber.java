package main.sqlipa.parser.ast.stmt.pragma;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.UnaryExpr;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class PragmaNumber extends PragmaValue {
    
    private UnaryExpr number;
    
    public PragmaNumber() {
        super();
    }
    
    public PragmaNumber(Block block, UnaryExpr number) {
        super(block);
        this.number = number;
    }
    
    public UnaryExpr getNumber() {
        return number;
    }
    
    public void setNumber(UnaryExpr number) {
        this.number = number;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}