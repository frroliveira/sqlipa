package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.SignedNumber;
import main.sqlipa.parser.ast.name.ConstraintName;

public class NumberColumnConstraint extends DefaultColumnConstraint {

    private SignedNumber number;
    
    public NumberColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name, SignedNumber number) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.number = number;
    }
    
    public SignedNumber getNumber() {
        return number;
    }
    
    public void setNumber(SignedNumber number) {
        this.number = number;
    }
    
}