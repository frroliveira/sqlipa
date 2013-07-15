package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class NotNullColumnConstraint extends ColumnConstraint {

    ConflictClause clause;
    
    public NotNullColumnConstraint(Block block, ConstraintName name,
            ConflictClause clause) {
        super(block, name);
        this.clause = clause;
    }
    
    public ConflictClause getClause() {
        return clause;
    }
    
    public void setClause(ConflictClause clause) {
        this.clause = clause;
    }
    
}