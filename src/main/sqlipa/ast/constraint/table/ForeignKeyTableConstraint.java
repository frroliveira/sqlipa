package main.sqlipa.ast.constraint.table;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.ForeignKeyClause;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ForeignKeyTableConstraint extends TableConstraint {

    public ForeignKeyClause clause;
    
    public List<Name> columns;
    
    public ForeignKeyTableConstraint() {
        super();
    }

    public ForeignKeyTableConstraint(Block block, Name name, ForeignKeyClause clause,
            List<Name> columns) {
        super(block, name);
        this.clause = clause;
        this.columns = columns;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}