package main.sqlipa.ast.stmt.event.update;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ColumnAssignment extends Node {
    
    public Name column;
    
    public Expression expr;
    
    public ColumnAssignment() {
        super();
    }
    
    public ColumnAssignment(Block block, Name column, Expression expr) {
        super(block);
        this.column = column;
        this.expr = expr;
    }
    
    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}