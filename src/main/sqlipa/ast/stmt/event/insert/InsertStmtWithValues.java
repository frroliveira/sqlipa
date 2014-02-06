package main.sqlipa.ast.stmt.event.insert;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InsertStmtWithValues extends InsertStmt {
    
    private List<Name> columns;
    
    private List<List<Expression>> rows;
    
    public InsertStmtWithValues() {
        super();
        columns = new LinkedList<Name>();
        rows = new LinkedList<List<Expression>>();
    }
    
    public InsertStmtWithValues(InsertStmt stmt) {
        super(stmt, stmt.getExplain(), stmt.getType(),
                new Name(stmt.getDatabase()),
                new Name(stmt.getTable()));
    }
    
    public InsertStmtWithValues(Block block, Explain explain, Type type,
            Name db, Name tab, List<Name> columns,
            List<List<Expression>> rows) {
        super(block, explain, type, db, tab);
        this.columns = columns;
        this.rows = rows;
    }
    
    public List<Name> getColumns() {
        return columns;
    }
    
    public List<List<Expression>> getRows() {
        return rows;
    }
    
    public void setColumns(List<Name> columns) {
        this.columns = columns;
    }
    
    public void setRows(List<List<Expression>> rows) {
        this.rows = rows;
    }
    
    public void addColumn(Name column) {
        columns.add(column);
    }
    
    public void addRow() {
        rows.add(new LinkedList<Expression>());
    }
    
    public void addRow(List<Expression> row) {
        rows.add(row);
    }
    
    public void addValue(Expression expr) {
        if (rows.size() == 0) {
            addRow();
        }
        addValue(expr, rows.size() - 1);
    }
    
    public boolean addValue(Expression value, int index) {
        if (index >= rows.size()) {
            return false;
        }
        rows.get(index).add(value);
        return true;
    }
    
    public boolean removeColumn(Name column) {
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}