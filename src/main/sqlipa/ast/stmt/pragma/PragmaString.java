package main.sqlipa.ast.stmt.pragma;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.literal.StringLiteral;
import main.sqlipa.ast.visitor.VoidVisitor;

public class PragmaString extends PragmaValue {
    
    public StringLiteral string;
    
    public PragmaString() {
        super();
    }
    
    public PragmaString(Block block, StringLiteral string) {
        super(block);
        this.string = string;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}