package main.sqlipa.ast.constraint.column;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.ForeignKeyClause;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ForeignKeyColumnConstraint extends ColumnConstraint {

    public ForeignKeyClause clause;
    
    public ForeignKeyColumnConstraint() {
        super();
    }
    
    public ForeignKeyColumnConstraint(Block block, Name name,
            ForeignKeyClause clause) {
        super(block, name);
        this.clause = clause;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}