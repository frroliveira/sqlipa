package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;

public class JoinCompound extends JoinSrc {
    
    public enum Operator {
        COMMA,
        JOIN,
        LEFT_JOIN,
        LEFT_OUTER_JOIN,
        INNER_JOIN,
        CROSS_JOIN,
        NATURAL_JOIN,
        NATURAL_LEFT_JOIN,
        NATURAL_LEFT_OUTER_JOIN,
        NATURAL_INNER_JOIN,
        NATURAL_CROSS_JOIN
    }
    
    private JoinSrc left;
    
    private JoinSrc right;
    
    private Operator op;
    
    private JoinConstraint constraint;
    
    public JoinCompound() {
        super();
    }
    
    public JoinCompound(Block block, JoinSrc left, JoinSrc right, Operator op,
            JoinConstraint constraint) {
        super(block);
        this.left = left;
        this.right = right;
        this.op = op;
        this.constraint = constraint;
    }

    public JoinSrc getLeft() {
        return left;
    }
    
    public JoinSrc getRight() {
        return right;
    }
    
    public Operator getOperator() {
        return op;
    }

    public JoinConstraint getConstraint() {
        return constraint;
    }
    
    public void setLeft(JoinSrc left) {
        this.left = left;
    }
    
    public void setRight(JoinSrc right) {
        this.right = right;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
    public void setConstraint(JoinConstraint constraint) {
        this.constraint = constraint;
    }
    
}