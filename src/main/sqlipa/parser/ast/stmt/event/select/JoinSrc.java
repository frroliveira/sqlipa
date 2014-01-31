package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public abstract class JoinSrc extends Node {
    
    public JoinSrc() {
        super();
    }
    
    public JoinSrc(Block block) {
        super(block);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}