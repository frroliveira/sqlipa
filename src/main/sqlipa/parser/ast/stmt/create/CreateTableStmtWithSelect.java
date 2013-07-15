package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class CreateTableStmtWithSelect extends CreateTableStmt {

    SelectStmt select;

    public CreateTableStmtWithSelect(Block block, Explain explain, 
            boolean hasIfNotExists, DatabaseName db, Name name, boolean hasTemp,
            SelectStmt select) {
        super(block, explain, hasIfNotExists, db, name, hasTemp);
        this.select = select;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }
    
}