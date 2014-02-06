package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

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
    
    private Operator op;

    private JoinSrc right;
    
    private JoinConstraint constraint;
    
    public JoinCompound() {
        super();
    }
    
    public JoinCompound(Block block, JoinSrc left, Operator op, JoinSrc right,
            JoinConstraint constraint) {
        super(block);
        this.left = left;
        this.op = op;
        this.right = right;
        this.constraint = constraint;
    }

    public JoinSrc getLeft() {
        return left;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public JoinSrc getRight() {
        return right;
    }

    public JoinConstraint getConstraint() {
        return constraint;
    }
    
    public void setLeft(JoinSrc left) {
        this.left = left;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
    public void setRight(JoinSrc right) {
        this.right = right;
    }
    
    public void setConstraint(JoinConstraint constraint) {
        this.constraint = constraint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}