package main.sqlipa.parser.ast.name;

public class ColumnAlias extends Alias {

    public ColumnAlias(String name) {
        super(name);
    }
    
    public ColumnAlias(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}