package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class BindParameterExpr extends Expression {

    public String parameter;
    
    public BindParameterExpr() {
        super();
    }
    
    public BindParameterExpr(Block block, String parameter) {
        super(block);
        this.parameter = parameter;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}