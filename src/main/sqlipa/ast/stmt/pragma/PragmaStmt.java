package main.sqlipa.ast.stmt.pragma;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.SqlStatement;
import main.sqlipa.ast.visitor.VoidVisitor;

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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}