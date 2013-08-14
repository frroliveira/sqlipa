package main.sqlipa.parser.ast;

public class BlockComment extends Comment {
    
    public BlockComment() {
        super();
    }
    
    public BlockComment(Block block, String content) {
        super(block, content);
    }
    
}