package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class BlockComment extends Comment {
    
    public BlockComment() {
        super();
    }
    
    public BlockComment(Block block, String content) {
        super(block, content);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}