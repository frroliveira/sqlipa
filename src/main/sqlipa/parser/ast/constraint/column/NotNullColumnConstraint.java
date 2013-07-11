package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class NotNullColumnConstraint extends ColumnConstraint {

    ConflictClause clause;
    
    public NotNullColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name, ConflictClause clause) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.clause = clause;
    }
    
    public ConflictClause getConflictClause() {
        return clause;
    }
    
    public void setConflictClause(ConflictClause clause) {
        this.clause = clause;
    }
    
}