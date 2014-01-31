package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class CreateTableStmtWithSelect extends CreateTableStmt {

    private SelectStmt select;
    
    public CreateTableStmtWithSelect() {
        super();
    }
    
    public CreateTableStmtWithSelect(CreateTableStmt stmt) {
        super(stmt, stmt.getExplain(), stmt.hasIfNotExists(),
                new Name(stmt.getDatabase()),
                new Name(stmt.getName()), stmt.hasTemporary());
    }
    
    public CreateTableStmtWithSelect(Block block, Explain explain, 
            boolean hasIfNotExists, Name db, Name name, boolean hasTemp,
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}