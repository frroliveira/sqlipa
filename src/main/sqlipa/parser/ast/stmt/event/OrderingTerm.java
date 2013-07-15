package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.CollationName;

public class OrderingTerm extends Node {
    
    public enum Order {
        ASC,
        DESC
    }

    private Expression expr;
    
    private CollationName collation;
    
    private Order order;
    
    public OrderingTerm(Block block, Expression expr, CollationName collation,
            Order order) {
        super(block);
        this.expr = expr;
        this.collation = collation;
        this.order = order;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public CollationName getCollation() {
        return collation;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }
    
    public void setCollation(CollationName collation) {
        this.collation = collation;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
}