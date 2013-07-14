package main.sqlipa.parser.ast.expr;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class InTableExpr extends InExpr {

    private DatabaseName db;
    
    private TableName tab;
    
    public InTableExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Operator op, Expression expr, DatabaseName db,
            TableName tab) {
        super(beginLine, beginColumn, endLine, endColumn, op, expr);
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