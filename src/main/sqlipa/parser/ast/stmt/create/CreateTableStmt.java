package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public abstract class CreateTableStmt extends CreateStmt {

    private boolean temp;
    
    public CreateTableStmt(int beginLine, int beginColumn, int endLine,
            int endColumn, Explain explain, boolean hasIfNotExists,
            DatabaseName db, Name name, boolean hasTemp) {
        super(beginLine, beginColumn, endLine, endColumn, explain, 
                hasIfNotExists, db, name);
        this.temp = hasTemp;
    }
    
    public boolean hasTemporary() {
        return temp;
    }
    
    public void setTemporary(boolean hasTemp) {
        this.temp = hasTemp;
    }

}