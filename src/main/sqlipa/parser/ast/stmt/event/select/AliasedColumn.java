package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.name.ColumnAlias;

public class AliasedColumn extends ExpressionColumn {

    private ColumnAlias alias;
    
    public AliasedColumn(int beginLine, int beginColumn, int endLine,
            int endColumn, Expression expr, ColumnAlias alias) {
        super(beginLine, beginColumn, endLine, endColumn, expr);
        this.alias = alias;
    }
    
    public ColumnAlias getAlias() {
        return alias;
    }
    
    public void setAlias(ColumnAlias alias) {
        this.alias = alias;
    }
    
}