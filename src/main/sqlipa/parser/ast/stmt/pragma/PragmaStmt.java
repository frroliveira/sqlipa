package main.sqlipa.parser.ast.stmt.pragma;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.PragmaName;
import main.sqlipa.parser.ast.stmt.SqlStatement;

public class PragmaStmt extends SqlStatement {
    
    private DatabaseName db;
    
    private PragmaName pragma;
    
    private PragmaValue value;
    
    public PragmaStmt() {
        super();
    }
    
    public PragmaStmt(Block block, Explain explain, DatabaseName db,
            PragmaName pragma, PragmaValue value) {
        super(block, explain);
        this.db = db;
        this.pragma = pragma;
        this.value = value;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public PragmaName getPragma() {
        return pragma;
    }
    
    public PragmaValue getValue() {
        return value;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setPragma(PragmaName pragma) {
        this.pragma = pragma;
    }
    
    public void setValue(PragmaValue value) {
        this.value = value;
    }

}