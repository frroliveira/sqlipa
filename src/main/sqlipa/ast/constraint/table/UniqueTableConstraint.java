package main.sqlipa.ast.constraint.table;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.IndexedColumn;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.ConflictClause;
import main.sqlipa.ast.visitor.VoidVisitor;

public class UniqueTableConstraint extends TableConstraint {
    
    public ConflictClause clause;

    public List<IndexedColumn> columns;

    public UniqueTableConstraint() {
        super();
    }
            
    public UniqueTableConstraint(Block block, Name name, ConflictClause clause,
            List<IndexedColumn> columns) {
        super(block, name);
        this.clause = clause;
        this.columns = columns;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}