package main.sqlipa.ast.literal;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class StringLiteral extends Literal {

    public StringLiteral() {
        super();
    }
    
    public StringLiteral(Block block, String value) {
        super(block, value);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}