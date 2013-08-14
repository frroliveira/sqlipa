package main.sqlipa.parser.ast;

public class LineComment extends Comment {
    
    public LineComment() {
        super();
    }
    
    public LineComment(Block block, String content) {
        super(block, content);
    }
    
}