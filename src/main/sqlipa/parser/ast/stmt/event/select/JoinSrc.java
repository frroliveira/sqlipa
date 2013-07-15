package main.sqlipa.parser.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;

public class JoinSrc extends SingleSrc {

    private SingleSrc src;
    
    private List<JoinOperation> ops;
    
    public JoinSrc(Block block, SingleSrc src) {
        this(block, src, new LinkedList<JoinOperation>());
    }
    
    public JoinSrc(Block block, SingleSrc src, List<JoinOperation> ops) {
        super(block);
        this.src = src;
        this.ops = ops;
    }
    
    public SingleSrc getSource() {
        return src;
    }
    
    public List<JoinOperation> getOperations() {
        return ops;
    }
    
    public void setSource(SingleSrc src) {
        this.src = src;
    }
    
    public void setOperations(List<JoinOperation> ops) {
        this.ops = ops;
    }
    
}