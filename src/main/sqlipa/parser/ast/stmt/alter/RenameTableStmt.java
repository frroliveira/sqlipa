package main.sqlipa.parser.ast.stmt.alter;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}