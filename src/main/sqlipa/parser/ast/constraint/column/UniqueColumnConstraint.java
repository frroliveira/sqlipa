package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class UniqueColumnConstraint extends ColumnConstraint {

    ConflictClause clause;
    
    public UniqueColumnConstraint(ConflictClause clause) {
        super();
        this.clause = clause;
    }
    
    public UniqueColumnConstraint(Block block, ConstraintName name,
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