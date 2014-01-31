package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class SelectCompound extends SelectUnit {

    public enum Operator {
        UNION,
        UNION_ALL,
        INTERSECT,
        EXCEPT
    }
    
    private SelectUnit left;

    private Operator op;
    
    private SelectUnit right;
    
    public SelectCompound() {
        super();
    }
    
    public SelectCompound(Block block, SelectUnit left, Operator op,
            SelectUnit right) {
        super(block);
        this.left = left;
        this.op = op;
        this.right = right;
    }
    
    public SelectUnit getLeft() {
        return left;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public SelectUnit getRight() {
        return right;
    }
    
    public void setLeft(SelectUnit left) {
        this.left = left;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
    public void setRight(SelectUnit right) {
        this.right = right;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}