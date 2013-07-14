package main.sqlipa.parser.ast.literal;

public class NumericLiteral extends Literal {

    public NumericLiteral(int beginLine, int beginColumn, int endLine,
            int endColumn, String value) {
        super(beginLine, beginColumn, endLine, endColumn, value);
    }
    
}