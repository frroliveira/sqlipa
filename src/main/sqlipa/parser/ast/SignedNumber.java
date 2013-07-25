package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.literal.NumericLiteral;

public class SignedNumber extends Node {
    
    public enum Sign {
        PLUS,
        MINUS
    }
    
    private Sign sign;
    
    private NumericLiteral literal;
    
    public SignedNumber() {
        super();
    }
    
    public SignedNumber(Block block, Sign sign, NumericLiteral literal) {
        super(block);
        this.sign = sign;
        this.literal = literal;
    }
    
    public Sign getSign() {
        return sign;
    }
    
    public NumericLiteral getLiteral() {
        return literal;
    }
    
    public void setSign(Sign sign) {
        this.sign = sign;
    }
    
    public void setLiteral(NumericLiteral literal) {
        this.literal = literal;
    }
    
}