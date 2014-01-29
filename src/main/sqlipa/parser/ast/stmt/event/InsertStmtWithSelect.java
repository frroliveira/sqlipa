package main.sqlipa.parser.ast.stmt.event;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class InsertStmtWithSelect extends InsertStmt {
    
    private List<Name> columns;
    
    private SelectStmt select;
    
    public InsertStmtWithSelect() {
        super();
        columns = new LinkedList<Name>();
    }
    
    public InsertStmtWithSelect(InsertStmt stmt) {
        super(stmt, stmt.getExplain(), stmt.getType(),
                new Name(stmt.getDatabase()),
                new Name(stmt.getTable()));
    }
    
    public InsertStmtWithSelect(Block block, Explain explain, Type type,
            Name db, Name tab, List<Name> columns,
            SelectStmt select) {
        super(block, explain, type, db, tab);
        this.columns = columns;
        this.select = select;
    }
    
    public List<Name> getColumns() {
        return columns;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public void setColumns(List<Name> columns) {
        this.columns = columns;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }

    public void addColumn(Name column) {
        columns.add(column);
    }
    
    public boolean removeColumn(Name column) {
        return columns.remove(column);
    }

}