package main.sqlipa.ast.expr;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ColumnExpr extends Expression {

    public Name database;
    
    public Name table;
    
    public Name column;
    
    public ColumnExpr() {
        super();
    }
    
    public ColumnExpr(Block block, Name database, Name table, Name column) {
        super(block);
        this.database = database;
        this.table = table;
        this.column = column;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}