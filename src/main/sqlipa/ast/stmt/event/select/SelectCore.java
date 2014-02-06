package main.sqlipa.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SelectCore extends SelectUnit {
    
    private boolean distinct;
    
    private List<ResultColumn> columns;
    
    private JoinSrc from;
    
    private Expression where;
    
    private List<Expression> groupBy;
    
    private Expression having;
    
    public SelectCore() {
        super();
        this.columns = new LinkedList<ResultColumn>();
        this.groupBy = new LinkedList<Expression>();
    }
    
    public SelectCore(Block block, boolean hasDistinct,
            List<ResultColumn> columns, JoinSrc from, Expression where,
            List<Expression> groupBy, Expression having) {
        super(block);
        this.distinct = hasDistinct;
        this.columns = columns;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
        this.having = having;
    }
    
    public boolean hasDistinct() {
        return distinct;
    }

    public List<ResultColumn> getColumns() {
        return columns;
    }
    
    public JoinSrc getFrom() {
        return from;
    }
    
    public Expression getWhere() {
        return where;
    }
    
    public List<Expression> getGroupBy() {
        return groupBy;
    }
    
    public Expression getHaving() {
        return having;
    }
    
    public void setDistinct(boolean hasDistinct) {
        this.distinct = hasDistinct;
    }

    public void setColumns(List<ResultColumn> columns) {
        this.columns = columns;
    }

    public void setFrom(JoinSrc from) {
        this.from = from;
    }
    
    public void setWhere(Expression where) {
        this.where = where;
    }

    public void setGroupBy(List<Expression> groupBy) {
        this.groupBy = groupBy;
    }
    
    public void setHaving(Expression having) {
        this.having = having;
    }
    
    public void addColumn(ResultColumn column) {
        columns.add(column);
    }
    
    public void addGroupByExpression(Expression expr) {
        groupBy.add(expr);
    }
    
    public boolean removeColumn(ResultColumn column) {
        return columns.remove(column);
    }
    
    public boolean removeGroupByExpression(Expression expr) {
        return groupBy.remove(expr);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}