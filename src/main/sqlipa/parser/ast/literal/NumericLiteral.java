package main.sqlipa.parser.ast.literal;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class NumericLiteral extends Literal {

    public NumericLiteral(Block block, String value) {
        super(block, value);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}