package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class AlterTableStmt extends SqlStatement {

    private Name database;
    
    private Name table;
    
    public AlterTableStmt() {
        super();
    }
    
    public AlterTableStmt(Block block, Explain explain, Name database,
            Name table) {
        super(block, explain);
        this.database = database;
        this.table = table;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getTable() {
        return table;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }
    
}