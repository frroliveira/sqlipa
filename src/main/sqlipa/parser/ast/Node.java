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
    
    public final Object getData() {
        return data;
    }
    
    public void setBlock(Block block) {
        this.block = block;
    }
    
    public final void setData(Object data) {
        this.data = data;
    }

}