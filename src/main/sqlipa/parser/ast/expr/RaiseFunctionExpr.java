package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.RaiseFunction;

public class RaiseFunctionExpr extends Expression {

    private RaiseFunction function;
    
    public RaiseFunctionExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, RaiseFunction function) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.function = function;
    }
    
    public RaiseFunction getFunction() {
        return function;
    }
    
    public void setFunction(RaiseFunction function) {
        this.function = function;
    }
    
}