package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;

public class VacuumStmt extends SqlStatement {
    
    public VacuumStmt() {
        super();
    }
    
    public VacuumStmt(Block block, Explain explain) {
        super(block, explain);
    }

}