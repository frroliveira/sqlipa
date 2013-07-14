package main.sqlipa.parser.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.name.ColumnName;

public class JoinConstraintUsing extends JoinConstraint {

    private List<ColumnName> columns;
    
    public JoinConstraintUsing(int beginLine, int beginColumn, int endLine,
            int endColumn) {
        this(beginLine, beginColumn, endLine, endColumn,
                new LinkedList<ColumnName>());
    }

    public JoinConstraintUsing(int beginLine, int beginColumn, int endLine,
            int endColumn, List<ColumnName> columns) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.columns = columns;
    }
    
    public List<ColumnName> getColumns() {
        return columns;
    }
    
    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }
    
}