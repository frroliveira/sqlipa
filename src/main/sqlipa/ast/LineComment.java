package main.sqlipa.ast;

import main.sqlipa.ast.visitor.VoidVisitor;

public class LineComment extends Comment {
    
    public LineComment() {
        super();
    }
    
    public LineComment(Block block, String content) {
        super(block, content);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}