package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public abstract class ResultColumn extends Node {
    
    public ResultColumn() {
        super();
    }
    
    public ResultColumn(Block block) {
        super(block);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}