package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.Name;

public class IndexedColumn extends Node {
    
    public enum Order {
        ASC,
        DESC
    }
    
    private Order order;
    
    private Name column;
    
    private Name collation;
    
    public IndexedColumn() {
        super();
    }
    
    public IndexedColumn(Block block, Order order, Name column,
            Name collation) {
        super(block);
        this.order = order;
        this.column = column;
        this.collation = collation;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public Name getColumn() {
        return column;
    }
    
    public Name getCollation() {
        return collation;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void setColumn(Name column) {
        this.column = column;
    }
    
    public void setCollation(Name collation) {
        this.collation = collation;
    }
    
}