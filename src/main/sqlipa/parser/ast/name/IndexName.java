package main.sqlipa.parser.ast.name;

public class IndexName extends Name {

    public IndexName(String name) {
        super(name);
    }
    
    public IndexName(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}