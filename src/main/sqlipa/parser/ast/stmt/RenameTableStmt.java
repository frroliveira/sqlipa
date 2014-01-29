package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class RenameTableStmt extends AlterTableStmt {
    
    private Name newTab;
        
    public RenameTableStmt() {
        super();
    }
    
    public RenameTableStmt(Block block, Explain explain, Name db,
            Name tab, Name newTab) {
        super(block, explain, db, tab);
        this.newTab = newTab;
    }
    
    public Name getNewTable() {
        return newTab;
    }

    public void setNewTable(Name newTab) {
        this.newTab = newTab;
    }

}