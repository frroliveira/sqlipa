package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.name.ConstraintName;

public abstract class TableConstraint extends Constraint {

    public TableConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}