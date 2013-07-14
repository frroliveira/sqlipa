package main.sqlipa.parser.ast.literal;

public class BlobLiteral extends Literal {

    public BlobLiteral(int beginLine, int beginColumn, int endLine,
            int endColumn, String value) {
        super(beginLine, beginColumn, endLine, endColumn, value);
    }
    
}