package main.sqlipa.parser.ast.literal;

import main.sqlipa.parser.ast.Block;

public class StringLiteral extends Literal {

    public StringLiteral(Block block, String value) {
        super(block, value);
    }
    
}