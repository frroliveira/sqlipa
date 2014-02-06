package main.sqlipa.ast.literal;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class NumericLiteral extends Literal {

    public NumericLiteral(Block block, String value) {
        super(block, value);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}