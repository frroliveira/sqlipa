package main.sqlipa.ast.stmt.event.select;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SelectCore extends SelectUnit {
    
    public boolean hasDistinct;
    
    public boolean hasAll;
    
    public List<ResultColumn> columns;
    
    public JoinSrc from;
    
    public Expression where;
    
    public List<Expression> groupBy;
    
    public Expression having;
    
    public SelectCore() {
        super();
    }
    
    public SelectCore(Block block, boolean hasDistinct, boolean hasAll,
    		List<ResultColumn> columns, JoinSrc from, Expression where, List<Expression> groupBy,
    		Expression having) {
        super(block);
        this.hasDistinct = hasDistinct;
        this.hasAll = hasAll;
        this.columns = columns;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
        this.having = having;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}