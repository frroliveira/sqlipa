package main.sqlipa.parser.ast.name;

public class DatabaseName extends Name {

    public DatabaseName(String name) {
        super(name);
    }
    
    public DatabaseName(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}