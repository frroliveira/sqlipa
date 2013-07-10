package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public abstract class CreateTableStmt extends CreateStmt {

    private boolean temp;
    
    public CreateTableStmt(int beginLine, int beginColumn, int endLine,
            int endColumn, Explain explain, boolean hasIfNotExists,
            DatabaseName db, Name struct, boolean temp) {
        super(beginLine, beginColumn, endLine, endColumn, explain, 
                hasIfNotExists, db, struct);
        this.temp = temp;
    }
    
    public boolean isTemporary() {
        return temp;
    }
    
    public void setTemporary(boolean temp) {
        this.temp = temp;
    }

}