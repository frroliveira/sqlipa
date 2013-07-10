package main.sqlipa.parser.ast.name;

public class ColumnName extends Name {

    public ColumnName(String name) {
        super(name);
    }
    
    public ColumnName(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }

}