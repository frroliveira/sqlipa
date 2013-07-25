package main.sqlipa.parser.ast.stmt.event.select;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.stmt.event.EventStmt;
import main.sqlipa.parser.ast.stmt.event.OrderingTerm;

public class SelectStmt extends EventStmt {

    private SelectUnit unit;
    
    private Expression limit;
    
    private Expression offset;
        
    private List<OrderingTerm> terms;

    public SelectStmt() {
        super();
        this.terms = new LinkedList<OrderingTerm>();
    }
    
    public SelectStmt(Block block, Explain explain, SelectUnit unit,
            Expression limit, Expression offset, List<OrderingTerm> terms) {
        super(block, explain);
        this.unit = unit;
        this.limit = limit;
        this.offset = offset;
        this.terms = terms;
    }
    
    public SelectUnit getUnit() {
        return unit;
    }

    public Expression getLimit() {
        return limit;
    }
    
    public Expression getOffset() {
        return offset;
    }
    
    public List<OrderingTerm> getTerms() {
        return terms;
    }
    
    public void setUnit(SelectUnit unit) {
        this.unit = unit;
    }
    
    public void setLimit(Expression limit) {
        this.limit = limit;
    }
    
    public void setOffset(Expression offset) {
        this.offset = offset;
    }
    
    public void setTerms(List<OrderingTerm> terms) {
        this.terms = terms;
    }
    
    public void addTerm(OrderingTerm term) {
        terms.add(term);
    }
    
    public boolean removeTerm(OrderingTerm term) {
        return terms.remove(term);
    }
    
}