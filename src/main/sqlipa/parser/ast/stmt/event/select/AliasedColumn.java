package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.ColumnAlias;

public class AliasedColumn extends ExpressionColumn {

    private ColumnAlias alias;
    
    public AliasedColumn() {
        super();
    }
    
    public AliasedColumn(Block block, Expression expr, ColumnAlias alias) {
        super(block, expr);
        this.alias = alias;
    }
    
    public ColumnAlias getAlias() {
        return alias;
    }
    
    public void setAlias(ColumnAlias alias) {
        this.alias = alias;
    }
    
}