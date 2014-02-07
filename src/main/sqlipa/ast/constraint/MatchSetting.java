package main.sqlipa.ast.constraint;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class MatchSetting extends ForeignKeySetting {
    
    public Name name;
    
    public MatchSetting() {
        super();
    }
    
    public MatchSetting(Block block, Name name) {
        super(block);
        this.name = name;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}