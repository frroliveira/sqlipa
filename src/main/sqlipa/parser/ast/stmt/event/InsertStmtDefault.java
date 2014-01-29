package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

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

}