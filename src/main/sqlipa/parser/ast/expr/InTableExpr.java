package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class InTableExpr extends InExpr {

    private DatabaseName db;
    
    private TableName tab;
    
    public InTableExpr(Block block, Operator op, Expression expr,
            DatabaseName db, TableName tab) {
        super(block, op, expr);
        this.db = db;
        this.tab = tab;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
}