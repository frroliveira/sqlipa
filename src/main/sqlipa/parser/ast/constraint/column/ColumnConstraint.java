package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.constraint.Constraint;
import main.sqlipa.parser.ast.name.ConstraintName;

public class ColumnConstraint extends Constraint {

    public ColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}