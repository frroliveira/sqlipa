package main.sqlipa.ast.stmt.create;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateViewStmt extends CreateStmt {
    
    private boolean temp;
    
    private SelectStmt select;
    
    public CreateViewStmt() {
        super();
    }
    
    public CreateViewStmt(Block block, Explain explain, boolean hasIfNotExists,
            Name db, Name name, boolean hasTemp, SelectStmt select) {
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}