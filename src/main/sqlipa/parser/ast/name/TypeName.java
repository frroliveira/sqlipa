package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.UnaryExpr;

public class TypeName extends Name {
    
    private UnaryExpr xDim;
    
    private UnaryExpr yDim;
    
    public TypeName() {
        super();
    }
    
    public TypeName(Name name) {
        super(new Block(name), new String(name.getName()));
    }
     
    public TypeName(Block block, String name, UnaryExpr xDim, UnaryExpr yDim) {
        super(block, name);
        this.xDim = xDim;
        this.yDim = yDim;
    }
    
    public UnaryExpr getDimensionInX() {
        return xDim;
    }
    
    public UnaryExpr getDimensionInY() {
        return yDim;
    }
    
    public void setDimensionInX(UnaryExpr xDim) {
        this.xDim = xDim;
    }
    
    public void setDimensionInY(UnaryExpr yDim) {
        this.yDim = yDim;
    }

}