package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.ForeignKeyClause;
import main.sqlipa.parser.ast.Name;

public class ForeignKeyColumnConstraint extends ColumnConstraint {

    private ForeignKeyClause clause;
    
    public ForeignKeyColumnConstraint() {
        super();
    }
    
    public ForeignKeyColumnConstraint(Block block, Name name,
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