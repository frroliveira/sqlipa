package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class MatchSetting extends ForeignKeySetting {
    
    private Name name;
    
    public MatchSetting() {
        super();
    }
    
    public MatchSetting(Block block, Name name) {
        super(block);
        this.name = name;
    }

    public Name getName() {
        return name;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
}