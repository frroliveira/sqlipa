package main.sqlipa.parser.ast.stmt.event.update;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.ColumnName;

public class ColumnAssign extends Node {
    
    private ColumnName column;
    
    private Expression expr;
    
    public ColumnAssign() {
        super();
    }
    
    public ColumnAssign(Block block, ColumnName column, Expression expr) {
        super(block);
        this.column = column;
        this.expr = expr;
    }
    
    public ColumnName getColumn() {
        return column;
    }
    
    public Expression getExpr() {
        return expr;
    }
    
    public void setColumn(ColumnName column) {
        this.column = column;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }

}