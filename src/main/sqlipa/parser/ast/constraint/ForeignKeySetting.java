package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Node;

public class ForeignKeySetting extends Node {
    
    public ForeignKeySetting(int beginLine, int beginColumn, int endLine, 
            int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
    }
    
}