package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class CreateViewStmt extends CreateStmt {
    
    private boolean temp;
    
    private SelectStmt select;
    
    public CreateViewStmt() {
        super();
    }
    
    public CreateViewStmt(Block block, Explain explain, boolean hasIfNotExists,
            DatabaseName db, Name name, boolean hasTemp, SelectStmt select) {
        super(block, explain, hasIfNotExists, db, name);
        this.temp = hasTemp;
        this.select = select;
    }
    
    public boolean hasTemporary() {
        return temp;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public void setTemporary(boolean hasTemp) {
        this.temp = hasTemp;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }

}