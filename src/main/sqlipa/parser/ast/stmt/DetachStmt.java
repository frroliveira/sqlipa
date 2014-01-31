package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class DetachStmt extends SqlStatement {
    
    private Name database;
    
    public DetachStmt() {
        super();
    }
    
    public DetachStmt(Block block, Explain explain, Name database) {
        super(block, explain);
        this.database = database;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}