package main.sqlipa.parser.ast.name;

public class ConstraintName extends Name {

    public ConstraintName(String name) {
        super(name);
    }
    
    public ConstraintName(int beginLine, int beginColumn, int endLine,
            int endColumn, String name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }

}