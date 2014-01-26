package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class RenameTableStmt extends AlterTableStmt {
    
    private TableName newTab;
        
    public RenameTableStmt() {
        super();
    }
    
    public RenameTableStmt(Block block, Explain explain, DatabaseName db,
            TableName tab, TableName newTab) {
        super(block, explain, db, tab);
        this.newTab = newTab;
    }
    
    public TableName getNewTable() {
        return newTab;
    }

    public void setNewTable(TableName newTab) {
        this.newTab = newTab;
    }

}