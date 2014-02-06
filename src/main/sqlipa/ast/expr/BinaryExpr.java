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
    
    private Expression left;
    
    private Expression right;
    
    private Operator op;
    
    public BinaryExpr() {
        super();
    }
    
    public BinaryExpr(Block block, Expression left, Expression right,
            Operator op) {
        super(block);
        this.left = left;
        this.right = right;
        this.op = op;
    }
    
    public Expression getLeft() {
        return left;
    }
    
    public Expression getRight() {
        return right;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public void setLeft(Expression left) {
        this.left = left;
    }
    
    public void setRight(Expression right) {
        this.right = right;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}