package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class ColumnExpr extends Expression {

    private Name database;
    
    private Name table;
    
    private Name column;
    
    public ColumnExpr() {
        super();
    }
    
    public ColumnExpr(Block block, Name database, Name table, Name column) {
        super(block);
        this.database = database;
        this.table = table;
        this.column = column;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getTable() {
        return table;
    }
    
    public Name getColumn() {
        return column;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }
    
    public void setColumn(Name column) {
        this.column = column;
    }
    
}