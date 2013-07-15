package main.sqlipa.parser.ast.literal;

import main.sqlipa.parser.ast.Block;

public class BlobLiteral extends Literal {

    public BlobLiteral(Block block, String value) {
        super(block, value);
    }
    
}