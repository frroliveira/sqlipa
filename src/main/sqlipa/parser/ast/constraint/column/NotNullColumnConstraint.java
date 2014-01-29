package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.Name;

public class NotNullColumnConstraint extends ColumnConstraint {

    private ConflictClause clause;
    
    public NotNullColumnConstraint() {
        super();
    }
    
    public NotNullColumnConstraint(Block block, Name name,
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