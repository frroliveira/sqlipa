package main.sqlipa.ast.stmt.event.insert;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InsertStmtWithSelect extends InsertStmt {
    
    public List<Name> columns;
    
    public SelectStmt select;
    
    public InsertStmtWithSelect() {
        super();
    }
    
    public InsertStmtWithSelect(InsertStmt stmt) {
        super(stmt, stmt.explain, stmt.type, new Name(stmt.database), new Name(stmt.table));
    }
    
    public InsertStmtWithSelect(Block block, Explain explain, Type type, Name database, Name table,
            List<Name> columns, SelectStmt select) {
        super(block, explain, type, database, table);
        this.columns = columns;
        this.select = select;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}