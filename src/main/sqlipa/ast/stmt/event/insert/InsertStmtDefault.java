package main.sqlipa.ast.stmt.event.insert;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InsertStmtDefault extends InsertStmt {
    
    public InsertStmtDefault() {
        super();
    }
    
    public InsertStmtDefault(InsertStmt stmt) {
        super(stmt, stmt.explain, stmt.type, new Name(stmt.database), new Name(stmt.table));
    }
    
    public InsertStmtDefault(Block block, Explain explain, Type type, Name database, Name table) {
        super(block, explain, type, database, table);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}