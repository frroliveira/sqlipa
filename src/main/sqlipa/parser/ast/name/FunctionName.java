package main.sqlipa.parser.ast.name;

public class FunctionName extends Name {

    public FunctionName(String name) {
        super(name);
    }
    
    public FunctionName(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}