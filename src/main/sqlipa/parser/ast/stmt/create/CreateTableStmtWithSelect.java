package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class CreateTableStmtWithSelect extends CreateTableStmt {

    private SelectStmt select;
    
    public CreateTableStmtWithSelect(SelectStmt select) {
        super();
        this.select = select;
    }

    public CreateTableStmtWithSelect(boolean hasIfNotExists, DatabaseName db, 
            Name name, boolean hasTemp, SelectStmt select) {
        super(null, null, hasIfNotExists, db, name, hasTemp);
        this.select = select;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }
    
}