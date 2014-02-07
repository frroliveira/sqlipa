package main.sqlipa.ast.stmt.create;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateViewStmt extends CreateStmt {
    
    public boolean hasTemporary;
    
    public SelectStmt select;
    
    public CreateViewStmt() {
        super();
    }
    
    public CreateViewStmt(Block block, Explain explain, boolean hasIfNotExists, Name database,
            Name name, boolean hasTemporary, SelectStmt select) {
        super(block, explain, hasIfNotExists, database, name);
        this.hasTemporary = hasTemporary;
        this.select = select;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}