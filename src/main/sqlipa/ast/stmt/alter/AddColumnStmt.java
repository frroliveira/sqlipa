package main.sqlipa.ast.stmt.alter;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.ColumnDef;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class AddColumnStmt extends AlterTableStmt {
    
    public ColumnDef column;
    
    public AddColumnStmt() {
        super();
    }
    
    public AddColumnStmt(Block block, Explain explain, Name database, Name table,
            ColumnDef column) {
        super(block, explain, database, table);
        this.column = column;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}