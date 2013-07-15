package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public class JoinOperation extends Node {
    
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
    
    private Operator op;
    
    private SingleSrc src;
    
    private JoinConstraint constraint;
    
    public JoinOperation(Block block, Operator op, SingleSrc src,
            JoinConstraint constraint) {
        super(block);
        this.op = op;
        this.src = src;
        this.constraint = constraint;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public SingleSrc getSource() {
        return src;
    }
    
    public JoinConstraint getConstraint() {
        return constraint;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
    public void setSource(SingleSrc src) {
        this.src = src;
    }
    
    public void setConstraint(JoinConstraint constraint) {
        this.constraint = constraint;
    }
    
}