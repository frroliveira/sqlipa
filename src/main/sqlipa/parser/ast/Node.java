package main.sqlipa.parser.ast;

// TODO: finish class.
public abstract class Node {

    private Block block;
    
    private Object data;
    
    public Node() {
    }
    
    public Node(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
    
    public int getBeginLine() {
        return block == null ? -1 : block.beginLine;
    }
    
    public int getBeginColumn() {
        return block == null ? -1 : block.beginColumn;
    }
    
    public int getEndLine() {
        return block == null ? -1 : block.endLine;
    }
    
    public int getEndColumn() {
        return block == null ? -1 : block.endColumn;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setBlock(Block block) {
        this.block = block;
    }
    
    public void setData(Object data) {
        this.data = data;
    }

}