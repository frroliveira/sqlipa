package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Node;

public abstract class ResultColumn extends Node {
    
    public ResultColumn(int beginLine, int beginColumn, int endLine,
            int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
    }
    
}