package main.sqlipa.parser.ast.stmt.event.insert;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class InsertStmtDefault extends InsertStmt {
    
    public InsertStmtDefault() {
        super();
    }
    
    public InsertStmtDefault(InsertStmt stmt) {
        super(stmt, stmt.getExplain(), stmt.getType(),
                new Name(stmt.getDatabase()),
                new Name(stmt.getTable()));
    }
    
    public InsertStmtDefault(Block block, Explain explain, Type type,
            Name db, Name tab) {
        super(block, explain, type, db, tab);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}