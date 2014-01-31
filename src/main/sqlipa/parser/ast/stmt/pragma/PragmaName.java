package main.sqlipa.parser.ast.stmt.pragma;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class PragmaName extends PragmaValue {
    
    private Name name;
    
    public PragmaName() {
        super();
    }
    
    public PragmaName(Block block, Name name) {
        super(block);
        this.name = name;
    }
    
    public Name getName() {
        return name;
    }
    
    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}