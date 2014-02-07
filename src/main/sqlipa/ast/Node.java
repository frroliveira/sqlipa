package main.sqlipa.ast;

import main.sqlipa.ast.visitor.VoidVisitor;

public abstract class Node extends Block {
   
    public Object data;
    
    public Node() {
        super();
    }
    
    public Node(Block block) {
        super(block);
    }

    public Node(Block block, Object data) {
        super(block);
        this.data = data;
    }

    public abstract void accept(VoidVisitor visitor);

}