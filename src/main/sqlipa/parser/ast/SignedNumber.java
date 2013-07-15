package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.literal.NumericLiteral;

public class SignedNumber extends Node {
    
    public enum Signal {
        PLUS,
        MINUS
    }
    
    private Signal signal;
    
    private NumericLiteral literal;
    
    public SignedNumber(Block block, Signal signal, NumericLiteral literal) {
        super(block);
        this.signal = signal;
        this.literal = literal;
    }
    
    public Signal getSignal() {
        return signal;
    }
    
    public NumericLiteral getLiteral() {
        return literal;
    }
    
    public void setSignal(Signal signal) {
        this.signal = signal;
    }
    
    public void setLiteral(NumericLiteral literal) {
        this.literal = literal;
    }
    
}