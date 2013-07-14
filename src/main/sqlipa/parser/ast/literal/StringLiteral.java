package main.sqlipa.parser.ast.literal;

public class StringLiteral extends Literal {

    public StringLiteral(int beginLine, int beginColumn, int endLine,
            int endColumn, String value) {
        super(beginLine, beginColumn, endLine, endColumn, value);
    }
    
}