package main.sqlipa.parser.ast.name;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.SignedNumber;

public class TypeName extends Name {
    
    private SignedNumber xDim;
    
    private SignedNumber yDim;
    
    public TypeName(String name, SignedNumber xDim, SignedNumber yDim) {
        super(name);
        this.xDim = xDim;
        this.yDim = yDim;
    }
    
    public TypeName(Block block, String name, SignedNumber xDim,
            SignedNumber yDim) {
        super(block, name);
        this.xDim = xDim;
        this.yDim = yDim;
    }
    
    public SignedNumber getDimensionInX() {
        return xDim;
    }
    
    public SignedNumber getDimensionInY() {
        return yDim;
    }
    
    public void setDimensionInX(SignedNumber xDim) {
        this.xDim = xDim;
    }
    
    public void setDimensionInY(SignedNumber yDim) {
        this.yDim = yDim;
    }

}