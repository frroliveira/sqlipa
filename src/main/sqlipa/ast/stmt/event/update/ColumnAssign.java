package main.sqlipa.ast.stmt.event.update;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ColumnAssign extends Node {
    
    private Name column;
    
    private Expression expr;
    
    public ColumnAssign() {
        super();
    }
    
    public ColumnAssign(Block block, Name column, Expression expr) {
        super(block);
        this.column = column;
        this.expr = expr;
    }
    
    public Name getColumn() {
        return column;
    }
    
    public Expression getExpr() {
        return expr;
    }
    
    public void setColumn(Name column) {
        this.column = column;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}