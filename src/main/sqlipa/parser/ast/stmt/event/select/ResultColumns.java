package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Node;

public abstract class ResultColumns extends Node {
    
    public ResultColumns(int beginLine, int beginColumn, int endLine,
            int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
    }
    
}