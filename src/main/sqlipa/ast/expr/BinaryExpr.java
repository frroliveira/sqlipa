package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class BinaryExpr extends Expression {

    public enum Operator {
        CONCATENATION,
        MULTIPLICATION,
        DIVISION,
        MODULO,
        ADDITION,
        SUBTRACTION,
        SHIFT_HIGH,
        SHIFT_LOW,
        BIT_AND,
        BIT_OR,
        ESCAPE,
        LESS,
        LESS_OR_EQUAL,
        GREATER,
        GREATER_OR_EQUAL,
        EQUAL,
        NOT_EQUAL,
        IS,
        IS_NOT,
        LIKE,
        GLOB,
        REGEXP,
        MATCH,
        NOT_LIKE,
        NOT_GLOB,
        NOT_REGEXP,
        NOT_MATCH,
        AND,
        OR
    }
    
    public Expression left;
    
    public Expression right;
    
    public Operator operator;
    
    public BinaryExpr() {
        super();
    }
    
    public BinaryExpr(Block block, Expression left, Expression right, Operator operator) {
        super(block);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}