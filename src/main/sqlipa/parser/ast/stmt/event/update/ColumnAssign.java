package main.sqlipa.parser.ast.stmt.event.update;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.Name;

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

}