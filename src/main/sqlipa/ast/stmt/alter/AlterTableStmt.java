package main.sqlipa.ast.stmt.alter;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.SqlStatement;

public abstract class AlterTableStmt extends SqlStatement {

    public Name database;
    
    public Name table;
    
    public AlterTableStmt() {
        super();
    }
    
    public AlterTableStmt(Block block, Explain explain, Name database, Name table) {
        super(block, explain);
        this.database = database;
        this.table = table;
    }

}