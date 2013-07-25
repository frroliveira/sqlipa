package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;

public class SelectCompound extends SelectUnit {

    public enum Operator {
        UNION,
        UNION_ALL,
        INTERSECT,
        EXCEPT
    }
    
    private SelectUnit left;
    
    private SelectUnit right;
    
    private Operator op;
    
    public SelectCompound() {
        super();
    }
    
    public SelectCompound(Block block, SelectUnit left, SelectUnit right,
            Operator op) {
        super(block);
        this.left = left;
        this.right = right;
        this.op = op;
    }
    
    public SelectUnit getLeft() {
        return left;
    }
    
    public SelectUnit getRight() {
        return right;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public void setLeft(SelectUnit left) {
        this.left = left;
    }
    
    public void setRight(SelectUnit right) {
        this.right = right;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
}