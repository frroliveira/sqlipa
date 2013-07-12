package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.name.Name;

public class MatchForeignKeySett extends ForeignKeySetting {
    
    private Name name;
    
    public MatchForeignKeySett(int beginLine, int beginColumn, int endLine,
            int endColumn, Name name) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.name = name;
    }

    public Name getName() {
        return name;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
}