package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SelectCompound extends SelectUnit {

    public enum Operator {
        UNION,
        UNION_ALL,
        INTERSECT,
        EXCEPT
    }
    
    public SelectUnit left;

    public Operator operator;
    
    public SelectUnit right;
    
    public SelectCompound() {
        super();
    }
    
    public SelectCompound(Block block, SelectUnit left, Operator operator, SelectUnit right) {
        super(block);
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}