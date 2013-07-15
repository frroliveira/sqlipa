package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public abstract class Expression extends Node {

    public Expression(Block block) {
        super(block);
    }
    
}