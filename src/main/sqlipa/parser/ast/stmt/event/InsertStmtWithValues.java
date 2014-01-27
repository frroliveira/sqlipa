package main.sqlipa.parser.ast.stmt.event;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class InsertStmtWithValues extends InsertStmt {
    
    private List<ColumnName> columns;
    
    private List<List<Expression>> rows;
    
    public InsertStmtWithValues() {
        super();
        columns = new LinkedList<ColumnName>();
        rows = new LinkedList<List<Expression>>();
    }
    
    public InsertStmtWithValues(Block block, Explain explain, Type type,
            DatabaseName db, TableName tab, List<ColumnName> columns,
            List<List<Expression>> rows) {
        super(block, explain, type, db, tab);
        this.columns = columns;
        this.rows = rows;
    }
    
    public List<ColumnName> getColumns() {
        return columns;
    }
    
    public List<List<Expression>> getRows() {
        return rows;
    }
    
    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }
    
    public void setRows(List<List<Expression>> rows) {
        this.rows = rows;
    }
    
    public void addColumn(ColumnName column) {
        columns.add(column);
    }
    
    public void addRow(List<Expression> row) {
        rows.add(row);
    }
    
    public boolean addValue(Expression value, int index) {
        if (index >= rows.size()) {
            return false;
        }
        rows.get(index).add(value);
        return true;
    }
    
    public boolean removeColumn(ColumnName column) {
        return columns.remove(column);
    }
    
    public boolean removeRow(List<Expression> row) {
        return rows.remove(row);
    }
    
    public boolean removeValue(List<Expression> value, int index) {
        if (index >= rows.size()) {
            return false;
        }
        return rows.get(index).remove(value);
    }

}