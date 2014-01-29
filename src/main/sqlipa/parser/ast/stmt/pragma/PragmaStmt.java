package main.sqlipa.parser.ast.stmt.pragma;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.stmt.SqlStatement;

public class PragmaStmt extends SqlStatement {
    
    private Name database;
    
    private Name pragma;
    
    private PragmaValue value;
    
    public PragmaStmt() {
        super();
    }
    
    public PragmaStmt(Block block, Explain explain, Name database,
            Name pragma, PragmaValue value) {
        super(block, explain);
        this.database = database;
        this.pragma = pragma;
        this.value = value;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getPragma() {
        return pragma;
    }
    
    public PragmaValue getValue() {
        return value;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setPragma(Name pragma) {
        this.pragma = pragma;
    }
    
    public void setValue(PragmaValue value) {
        this.value = value;
    }

}