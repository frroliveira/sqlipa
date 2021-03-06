package main.sqlipa.ast.stmt.event;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class OrderingTerm extends Node {
    
    public enum Order {
        ASC,
        DESC
    }

    public Expression expr;
        
    public Order order;
    
    public OrderingTerm() {
        super();
    }
    
    public OrderingTerm(Block block, Expression expr, Order order) {
        super(block);
        this.expr = expr;
        this.order = order;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}