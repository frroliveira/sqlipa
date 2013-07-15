package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public abstract class ResultColumn extends Node {
    
    public ResultColumn(Block block) {
        super(block);
    }
    
}