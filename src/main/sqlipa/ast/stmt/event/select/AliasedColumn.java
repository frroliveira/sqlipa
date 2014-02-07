package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class AliasedColumn extends ExpressionColumn {

    public Name alias;
    
    public AliasedColumn() {
        super();
    }
    
    public AliasedColumn(Block block, Expression expr, Name alias) {
        super(block, expr);
        this.alias = alias;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}