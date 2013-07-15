package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.RaiseFunction;

public class RaiseFunctionExpr extends Expression {

    private RaiseFunction function;
    
    public RaiseFunctionExpr(Block block, RaiseFunction function) {
        super(block);
        this.function = function;
    }
    
    public RaiseFunction getFunction() {
        return function;
    }
    
    public void setFunction(RaiseFunction function) {
        this.function = function;
    }
    
}