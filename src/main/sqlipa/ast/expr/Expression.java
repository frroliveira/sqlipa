package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;

public abstract class Expression extends Node {

    public Expression() {
        super();
    }
    
    public Expression(Block block) {
        super(block);
    }

}