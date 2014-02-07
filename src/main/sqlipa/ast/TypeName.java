package main.sqlipa.ast;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.expr.UnaryExpr;
import main.sqlipa.ast.visitor.VoidVisitor;

public class TypeName extends Name {
    
    public UnaryExpr xDimension;
    
    public UnaryExpr yDimension;
    
    public TypeName() {
        super();
    }
    
    public TypeName(Name name) {
        super(new Block(name), new String(name.name));
    }
     
    public TypeName(Block block, String name, UnaryExpr xDimension, UnaryExpr yDimension) {
        super(block, name);
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}