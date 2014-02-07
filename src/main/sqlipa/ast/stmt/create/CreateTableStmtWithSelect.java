package main.sqlipa.ast.stmt.create;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateTableStmtWithSelect extends CreateTableStmt {

    public SelectStmt select;
    
    public CreateTableStmtWithSelect() {
        super();
    }
    
    public CreateTableStmtWithSelect(CreateTableStmt stmt) {
        super(stmt, stmt.explain, stmt.hasIfNotExists, new Name(stmt.database), new Name(stmt.name),
                stmt.hasTemporary);
    }
    
    public CreateTableStmtWithSelect(Block block, Explain explain, boolean hasIfNotExists,
            Name database, Name name, boolean hasTemporary, SelectStmt select) {
        super(block, explain, hasIfNotExists, database, name, hasTemporary);
        this.select = select;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}