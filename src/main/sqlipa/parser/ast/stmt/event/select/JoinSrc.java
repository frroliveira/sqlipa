package main.sqlipa.parser.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

public class JoinSrc extends SingleSrc {

    private SingleSrc src;
    
    private List<JoinOperation> ops;
    
    public JoinSrc(int beginLine, int beginColumn, int endLine, int endColumn,
            SingleSrc src) {
        this(beginLine, beginColumn, endLine, endColumn, src,
                new LinkedList<JoinOperation>());
    }
    
    public JoinSrc(int beginLine, int beginColumn, int endLine, int endColumn,
            SingleSrc src, List<JoinOperation> ops) {
        super(beginLine, beginColumn, endLine, endColumn);
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