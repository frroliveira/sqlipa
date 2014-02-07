package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SavepointStmt extends SqlStatement {
    
    public Name savepoint;
    
    public SavepointStmt() {
        super();
    }
    
    public SavepointStmt(Block block, Explain explain,
            Name savepoint) {
        this.savepoint = savepoint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}