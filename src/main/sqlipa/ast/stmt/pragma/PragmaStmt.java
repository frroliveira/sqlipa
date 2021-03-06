package main.sqlipa.ast.stmt.pragma;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.SqlStatement;
import main.sqlipa.ast.visitor.VoidVisitor;

public class PragmaStmt extends SqlStatement {
    
    public Name database;
    
    public Name pragma;
    
    public PragmaValue value;
    
    public PragmaStmt() {
        super();
    }
    
    public PragmaStmt(Block block, Explain explain, Name database, Name pragma, PragmaValue value) {
        super(block, explain);
        this.database = database;
        this.pragma = pragma;
        this.value = value;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}