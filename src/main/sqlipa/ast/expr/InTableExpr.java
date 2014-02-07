package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InTableExpr extends InExpr {

    public Name database;
    
    public Name table;
    
    public InTableExpr() {
        super();
    }
    
    public InTableExpr(Block block, Operator operator, Expression expr, Name database, Name table) {
        super(block, operator, expr);
        this.database = database;
        this.table = table;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}