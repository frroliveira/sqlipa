package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class BindParameterExpr extends Expression {

    private String parameter;
    
    public BindParameterExpr() {
        super();
    }
    
    public BindParameterExpr(Block block, String parameter) {
        super(block);
        this.parameter = parameter;
    }
    
    public String getParameter() {
        return parameter;
    }
    
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}