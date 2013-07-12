package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.name.ConstraintName;

public class UniqueColumnConstraint extends ColumnConstraint {

    ConflictClause clause;
    
    public UniqueColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name, ConflictClause clause) {
        super(beginLine, beginColumn, endLine, endColumn, name);
        this.clause = clause;
    }
    
    public ConflictClause getClause() {
        return clause;
    }
    
    public void setClause(ConflictClause clause) {
        this.clause = clause;
    }
    
}