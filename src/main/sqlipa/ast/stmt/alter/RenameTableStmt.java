package main.sqlipa.ast.stmt.alter;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class RenameTableStmt extends AlterTableStmt {
    
    public Name newTable;
        
    public RenameTableStmt() {
        super();
    }
    
    public RenameTableStmt(Block block, Explain explain, Name database, Name table, Name newTable) {
        super(block, explain, database, table);
        this.newTable = newTable;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}