package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.FunctionName;

public class FunctionExpr extends Expression {

    private FunctionName function;
    
    // private List<Expression> ;
    // TODO: Do when reference is done.
    
    public FunctionExpr(Block block) {
        super(block);
    }
    
    public FunctionName getFunction() {
        return function;
    }
    
    public void setFunction(FunctionName function) {
        this.function = function;
    }
    
}