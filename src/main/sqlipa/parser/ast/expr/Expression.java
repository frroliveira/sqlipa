package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Node;

public abstract class Expression extends Node {

    public Expression(int beginLine, int beginColumn, int endLine,
            int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
    }
    
}