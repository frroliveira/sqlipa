package main.sqlipa.ast;

public abstract class Comment extends Node {
    
    public String content;
    
    public Comment() {
        super();
    }
    
    public Comment(Block block, String content) {
        super(block);
        this.content = content;
    }

}