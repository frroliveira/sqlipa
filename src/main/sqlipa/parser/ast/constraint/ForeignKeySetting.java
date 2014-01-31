package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public abstract class ForeignKeySetting extends Node {

    public ForeignKeySetting() {
        super();
    }
    
    public ForeignKeySetting(Block block) {
        super(block);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}