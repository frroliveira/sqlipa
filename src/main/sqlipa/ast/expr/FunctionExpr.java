package main.sqlipa.ast.expr;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class FunctionExpr extends Expression {

    public enum Operator {
        DISTINCT,
        UNIVERSAL
    }
    
    public Name function;
    
    public Operator operator;
    
    public List<Expression> exprs;
    
    public FunctionExpr() {
        super();
    }
    
    public FunctionExpr(Block block, Name function, Operator operator, List<Expression> exprs) {
        super(block);
        this.function = function;
        this.operator = operator;
        this.exprs = exprs;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}