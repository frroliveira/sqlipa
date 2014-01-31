package main.sqlipa.parser.ast.constraint.table;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.constraint.ForeignKeyClause;
import main.sqlipa.parser.ast.visitor.VoidVisitor;
import main.sqlipa.parser.ast.Name;

public class ForeignKeyTableConstraint extends TableConstraint {

    private ForeignKeyClause clause;
    
    private List<Name> columns;
    
    public ForeignKeyTableConstraint() {
        super();
        this.columns = new LinkedList<Name>();
    }

    public ForeignKeyTableConstraint(Block block, Name name,
            ForeignKeyClause clause, List<Name> columns) {
        super(block, name);
        this.clause = clause;
        this.columns = columns;
    }
    
    public ForeignKeyClause getClause() {
        return clause;
    }
    
    public List<Name> getColumns() {
        return columns;
    }
    
    public void setClause(ForeignKeyClause clause) {
        this.clause = clause;
    }
    
    public void setColumns(List<Name> columns) {
        this.columns = columns;
    }
    
    public void addColumn(Name column) {
        columns.add(column);
    }
    
    public boolean removeColumn(Name column) {
        return columns.remove(column);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}