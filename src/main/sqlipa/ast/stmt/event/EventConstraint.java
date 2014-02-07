package main.sqlipa.ast.stmt.event;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class EventConstraint extends Node {
    
    public List<OrderingTerm> terms;
    
    public Expression limit;
    
    public Expression offset;
    
    public EventConstraint() {
        super();
    }
    
    public EventConstraint(Block block, List<OrderingTerm> terms, Expression limit,
            Expression offset) {
        super(block);
        this.terms = terms;
        this.limit = limit;
        this.offset = offset;
    }
    
    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}