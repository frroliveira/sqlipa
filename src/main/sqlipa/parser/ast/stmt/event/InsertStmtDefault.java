package main.sqlipa.parser.ast.stmt.event;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class InsertStmtDefault extends InsertStmt {
    
    public InsertStmtDefault() {
        super();
    }
    
    public InsertStmtDefault(Block block, Explain explain, Type type,
            DatabaseName db, TableName tab) {
        super(block, explain, type, db, tab);
    }

}