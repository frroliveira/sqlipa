package main.sqlipa.parser.ast;

public abstract class Comment extends Node {
    
    private String content;
    
    public Comment() {
        super();
    }
    
    public Comment(Block block, String content) {
        super(block);
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
}