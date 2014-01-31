package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class RaiseFunctionExpr extends Expression {

    public enum Type {
        IGNORE,
        ROLLBACK,
        ABORT,
        FAIL
    }
    
    private Type type;
    
    private String error;
    
    public RaiseFunctionExpr() {
        super();
    }
    
    public RaiseFunctionExpr(Block block, Type type, String error) {
        super(block);
        this.type = type;
        this.error = error;
    }
    
    public Type getType() {
        return type;
    }
    
    public String getError() {
        return error;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}