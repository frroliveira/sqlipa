package main.sqlipa.parser.ast.name;

public class TableName extends Name {

    public TableName(String name) {
        super(name);
    }
    
    public TableName(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}