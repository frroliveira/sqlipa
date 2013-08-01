package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.expr.Expression;

public class OrderingTerm extends Node {
    
    public enum Order {
        ASC,
        DESC
    }

    private Expression expr;
        
    private Order order;
    
    public OrderingTerm() {
        super();
    }
    
    public OrderingTerm(Block block, Expression expr, Order order) {
        super(block);
        this.expr = expr;
        this.order = order;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
}