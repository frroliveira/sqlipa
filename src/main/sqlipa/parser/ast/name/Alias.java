package main.sqlipa.parser.ast.name;

public class Alias extends Name {

    public Alias(String name) {
        super(name);
    }
    
    public Alias(int beginLine, int beginColumn, int endLine, int endColumn,
            String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}