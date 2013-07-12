package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.constraint.ForeignKeyClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class ForeignKeyColumnConstraint extends ColumnConstraint {

    private ForeignKeyClause clause;
    
    public ForeignKeyColumnConstraint(int beginLine, int beginColumn,
            int endLine, int endColumn, ConstraintName name, 
            ForeignKeyClause clause) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.clause = clause;
    }
    
    public ForeignKeyClause getClause() {
        return clause;
    }
    
    public void setClause(ForeignKeyClause clause) {
        this.clause = clause;
    }
    
}