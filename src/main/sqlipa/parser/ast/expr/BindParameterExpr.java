package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;

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
    
}