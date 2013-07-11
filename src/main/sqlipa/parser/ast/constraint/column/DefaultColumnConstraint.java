package main.sqlipa.parser.ast.constraint.column;

import main.sqlipa.parser.ast.name.ConstraintName;

public abstract class DefaultColumnConstraint extends ColumnConstraint {

    public DefaultColumnConstraint(int beginLine, int beginColumn, int endLine,
            int endColumn, ConstraintName name) {
        super(beginLine, beginColumn, endLine, endColumn, name);
    }
    
}