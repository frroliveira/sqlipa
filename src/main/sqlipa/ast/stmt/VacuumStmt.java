package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class VacuumStmt extends SqlStatement {
    
    public VacuumStmt() {
        super();
    }
    
    public VacuumStmt(Block block, Explain explain) {
        super(block, explain);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}