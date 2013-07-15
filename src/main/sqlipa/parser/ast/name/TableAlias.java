package main.sqlipa.parser.ast.name;

public class TableAlias extends Alias {

    public TableAlias(String name) {
        super(name);
    }
    
    public TableAlias(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}