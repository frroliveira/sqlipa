package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class CreateTableStmtWithSelect extends CreateTableStmt {

    SelectStmt select;

    public CreateTableStmtWithSelect(int beginLine, int beginColumn,
            int endLine, int endColumn, Explain explain, boolean hasIfNotExists,
            DatabaseName db, Name name, boolean temp, SelectStmt select) {
        super(beginLine, beginColumn, endLine, endColumn, explain, 
                hasIfNotExists, db, name, temp);
        this.select = select;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }
    
}