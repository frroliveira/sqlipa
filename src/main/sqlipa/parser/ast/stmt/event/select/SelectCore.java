package main.sqlipa.parser.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;

public class SelectCore extends SelectUnit {
    
    private boolean distinct;
    
    private JoinSrc from;
    
    private Expression where;
    
    private Expression having;
    
    private List<ResultColumn> columns;
    
    private List<Expression> groupBy;
    
    public SelectCore() {
        super();
        this.columns = new LinkedList<ResultColumn>();
        this.groupBy = new LinkedList<Expression>();
    }
    
    public SelectCore(Block block, boolean returnsDistinct, JoinSrc from,
            Expression where, Expression having, List<ResultColumn> columns,
            List<Expression> groupBy) {
        super(block);
        this.distinct = returnsDistinct;
        this.from = from;
        this.where = where;
        this.having = having;
        this.columns = columns;
        this.groupBy = groupBy;
    }
    
    public boolean returnsDistinct() {
        return distinct;
    }
    
    public JoinSrc getFrom() {
        return from;
    }
    
    public Expression getWhere() {
        return where;
    }
    
    public Expression getHaving() {
        return having;
    }
    
    public List<ResultColumn> getColumns() {
        return columns;
    }
    
    public List<Expression> getGroupBy() {
        return groupBy;
    }
    
    public void setDistinct(boolean returnsDistinct) {
        this.distinct = returnsDistinct;
    }
    
    public void setFrom(JoinSrc from) {
        this.from = from;
    }
    
    public void setWhere(Expression where) {
        this.where = where;
    }
    
    public void setHaving(Expression having) {
        this.having = having;
    }
    
    public void setColumns(List<ResultColumn> columns) {
        this.columns = columns;
    }
    
    public void setGroupBy(List<Expression> groupBy) {
        this.groupBy = groupBy;
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

}