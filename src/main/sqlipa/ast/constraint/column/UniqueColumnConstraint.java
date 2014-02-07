package main.sqlipa.ast.constraint.column;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.ConflictClause;
import main.sqlipa.ast.visitor.VoidVisitor;

public class UniqueColumnConstraint extends ColumnConstraint {

    public ConflictClause clause;
    
    public UniqueColumnConstraint() {
        super();
    }
    
    public UniqueColumnConstraint(Block block, Name name, ConflictClause clause) {
        super(block, name);
        this.clause = clause;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}