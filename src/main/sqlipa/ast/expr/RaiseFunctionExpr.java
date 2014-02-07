package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class RaiseFunctionExpr extends Expression {

    public enum Type {
        IGNORE,
        ROLLBACK,
        ABORT,
        FAIL
    }
    
    public Type type;
    
    public String error;
    
    public RaiseFunctionExpr() {
        super();
    }
    
    public RaiseFunctionExpr(Block block, Type type, String error) {
        super(block);
        this.type = type;
        this.error = error;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}