package main.sqlipa.ast.stmt.alter;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.ColumnDef;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class AddColumnStmt extends AlterTableStmt {
    
    private ColumnDef column;
    
    public AddColumnStmt() {
        super();
    }
    
    public AddColumnStmt(Block block, Explain explain, Name db,
            Name tab, ColumnDef column) {
        super(block, explain, db, tab);
        this.column = column;
    }
    
    public ColumnDef getColumn() {
        return column;
    }
    
    public void setColumn(ColumnDef column) {
        this.column = column;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}