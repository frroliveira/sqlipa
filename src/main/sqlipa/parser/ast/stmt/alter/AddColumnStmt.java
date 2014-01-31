package main.sqlipa.parser.ast.stmt.alter;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.ColumnDef;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

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