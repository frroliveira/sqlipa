package main.sqlipa.parser.ast;

// TODO: finish class.
public abstract class Node extends Block {
   
    private Object data;
    
    public Node() {
    }
    
    public Node(Block block) {
        if (block != null)
            setBeginEnd(block);
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }

}