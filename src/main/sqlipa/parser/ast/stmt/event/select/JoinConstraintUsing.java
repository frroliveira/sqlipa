package main.sqlipa.parser.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class JoinConstraintUsing extends JoinConstraint {

    private List<Name> columns;
    
    public JoinConstraintUsing() {
        super();
        this.columns = new LinkedList<Name>();
    }

    public JoinConstraintUsing(Block block, List<Name> columns) {
        super(block);
        this.columns = columns;
    }
    
    public List<Name> getColumns() {
        return columns;
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