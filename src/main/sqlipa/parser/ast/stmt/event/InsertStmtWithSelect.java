package main.sqlipa.parser.ast.stmt.event;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;

public class InsertStmtWithSelect extends InsertStmt {
    
    private List<ColumnName> columns;
    
    private SelectStmt select;
    
    public InsertStmtWithSelect() {
        super();
        columns = new LinkedList<ColumnName>();
    }
    
    public InsertStmtWithSelect(Block block, Explain explain, Type type,
            DatabaseName db, TableName tab, List<ColumnName> columns,
            SelectStmt select) {
        super(block, explain, type, db, tab);
        this.columns = columns;
        this.select = select;
    }
    
    public List<ColumnName> getColumns() {
        return columns;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }

    public void addColumn(ColumnName column) {
        columns.add(column);
    }
    
    public boolean removeColumn(ColumnName column) {
        return columns.remove(column);
    }

}