package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Node;

public class JoinConstraint extends Node {
    
    public JoinConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
    }
    
}