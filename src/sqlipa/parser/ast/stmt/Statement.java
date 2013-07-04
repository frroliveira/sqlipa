package sqlipa.parser.ast.stmt;

import sqlipa.parser.ast.Node;

public class Statement extends Node {
    
    public Statement() {
    }
    
    public Statement(int beginLine, int beginColumn, int endLine, int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
    }
}