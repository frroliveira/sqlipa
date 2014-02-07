package main.sqlipa.ast.literal;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class BlobLiteral extends Literal {

    public BlobLiteral() {
        super();
    }
    
    public BlobLiteral(Block block, String value) {
        super(block, value);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}