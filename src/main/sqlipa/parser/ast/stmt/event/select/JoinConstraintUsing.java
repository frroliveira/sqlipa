package main.sqlipa.parser.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.ColumnName;

public class JoinConstraintUsing extends JoinConstraint {

    private List<ColumnName> columns;
    
    public JoinConstraintUsing() {
        super();
        this.columns = new LinkedList<ColumnName>();
    }

    public JoinConstraintUsing(Block block, List<ColumnName> columns) {
        super(block);
        this.columns = columns;
    }
    
    public List<ColumnName> getColumns() {
        return columns;
    }
    
    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }
    
    public void addColumn(ColumnName column) {
        columns.add(column);
    }
    
    public boolean removeColumn(ColumnName column) {
        return columns.remove(column);
    }
    
}