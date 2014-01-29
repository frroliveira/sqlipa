package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.Name;

public class AliasedColumn extends ExpressionColumn {

    private Name alias;
    
    public AliasedColumn() {
        super();
    }
    
    public AliasedColumn(Block block, Expression expr, Name alias) {
        super(block, expr);
        this.alias = alias;
    }
    
    public Name getAlias() {
        return alias;
    }
    
    public void setAlias(Name alias) {
        this.alias = alias;
    }
    
}