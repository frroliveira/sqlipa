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
    
    public JoinSrc left;
    
    public Operator operator;

    public JoinSrc right;
    
    public JoinConstraint constraint;
    
    public JoinCompound() {
        super();
    }
    
    public JoinCompound(Block block, JoinSrc left, Operator operator, JoinSrc right,
            JoinConstraint constraint) {
        super(block);
        this.left = left;
        this.operator = operator;
        this.right = right;
        this.constraint = constraint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}