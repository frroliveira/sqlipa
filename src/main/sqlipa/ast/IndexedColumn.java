package main.sqlipa.ast;

import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class IndexedColumn extends Node {
    
    public enum Order {
        ASC,
        DESC
    }
    
    public Order order;
    
    public Name column;
    
    public Name collation;
    
    public IndexedColumn() {
        super();
    }
    
    public IndexedColumn(Block block, Order order, Name column, Name collation) {
        super(block);
        this.order = order;
        this.column = column;
        this.collation = collation;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}