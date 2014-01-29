package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;

public class InTableExpr extends InExpr {

    private Name database;
    
    private Name table;
    
    public InTableExpr() {
        super();
    }
    
    public InTableExpr(Block block, Operator op, Expression expr, Name database,
            Name table) {
        super(block, op, expr);
        this.database = database;
        this.table = table;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getTable() {
        return table;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }
    
}