package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.ForeignKeyClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class ForeignKeyColumnConstraint extends ColumnConstraint {

    private ForeignKeyClause clause;
    
    public ForeignKeyColumnConstraint(ForeignKeyClause clause) {
        super();
        this.clause = clause;
    }
    
    public ForeignKeyColumnConstraint(Block block, ConstraintName name, 
            ForeignKeyClause clause) {
        super(block, name);
        this.clause = clause;
    }
    
    public ForeignKeyClause getClause() {
        return clause;
    }
    
    public void setClause(ForeignKeyClause clause) {
        this.clause = clause;
    }
    
}