package main.sqlipa.parser.ast.stmt.pragma;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.literal.StringLiteral;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class PragmaString extends PragmaValue {
    
    private StringLiteral string;
    
    public PragmaString() {
        super();
    }
    
    public PragmaString(Block block, StringLiteral string) {
        super(block);
        this.string = string;
    }
    
    public StringLiteral getString() {
        return string;
    }
    
    public void setString(StringLiteral string) {
        this.string = string;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}