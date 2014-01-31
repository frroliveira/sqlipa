package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public abstract class SingleSrc extends JoinSrc {
    
    public SingleSrc() {
        super();
    }
    
    public SingleSrc(Block block) {
        super(block);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}