package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.CollationName;
import main.sqlipa.parser.ast.name.ColumnName;

public class IndexedColumn extends Node {
    
    public enum Order {
        ASC,
        DESC
    }
    
    private Order order;
    
    private ColumnName column;
    
    private CollationName collation;
    
    public IndexedColumn(int beginLine, int beginColumn, int endLine,
            int endColumn, Order order, ColumnName column,
            CollationName collation) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.order = order;
        this.column = column;
        this.collation = collation;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public ColumnName getColumn() {
        return column;
    }
    
    public CollationName getCollation() {
        return collation;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void setColumn(ColumnName column) {
        this.column = column;
    }
    
    public void setCollation(CollationName collation) {
        this.collation = collation;
    }
    
}