package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class AddColumnStmt extends AlterTableStmt {
    
    private ColumnDef column;
    
    public AddColumnStmt() {
        super();
    }
    
    public AddColumnStmt(Block block, Explain explain, DatabaseName db,
            TableName tab, ColumnDef column) {
        super(block, explain, db, tab);
        this.column = column;
    }
    
    public ColumnDef getColumn() {
        return column;
    }
    
    public void setColumn(ColumnDef column) {
        this.column = column;
    }

}