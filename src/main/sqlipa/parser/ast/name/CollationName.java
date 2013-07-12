package main.sqlipa.parser.ast.name;

public class CollationName extends Name {

    public CollationName(String name) {
        super(name);
    }
    
    public CollationName(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}