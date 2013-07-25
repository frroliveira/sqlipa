package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.SignedNumber;
import main.sqlipa.parser.ast.name.ConstraintName;

public class NumberColumnConstraint extends DefaultColumnConstraint {

    private SignedNumber number;
    
    public NumberColumnConstraint() {
        super();
    }
    
    public NumberColumnConstraint(Block block, ConstraintName name,
            SignedNumber number) {
        super(block, name);
        this.number = number;
    }
    
    public SignedNumber getNumber() {
        return number;
    }
    
    public void setNumber(SignedNumber number) {
        this.number = number;
    }
    
}