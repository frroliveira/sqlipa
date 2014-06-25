package main.sqlipa.ast.stmt;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CommitStmt extends SqlStatement {
    
	public enum Type {
		COMMIT,
		END
	}
	
	public Type type;
	
    public boolean hasTransaction;

    public CommitStmt() {
        super();
    }
    
    public CommitStmt(Block block, Explain explain, Type type, boolean hasTransaction) {
        super(block, explain);
        this.type = type;
        this.hasTransaction = hasTransaction;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}