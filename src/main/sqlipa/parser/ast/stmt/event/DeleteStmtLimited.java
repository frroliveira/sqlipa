package main.sqlipa.parser.ast.stmt.event;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.expr.Expression;

public class DeleteStmtLimited extends DeleteStmt {
    
    private List<OrderingTerm> terms;
    
    private Expression limit;
    
    private Expression offset;
    
    public DeleteStmtLimited() {
        super();
        terms = new LinkedList<OrderingTerm>();
    }
    
    public DeleteStmtLimited(Block block, Explain explain,
            QualifiedTableName qualifiedTab, Expression where,
            List<OrderingTerm> terms, Expression limit, Expression offset) {
        super(block, explain, qualifiedTab, where);
        this.terms = terms;
        this.limit = limit;
        this.offset = offset;
    }
    
    public List<OrderingTerm> getTerms() {
        return terms;
    }
    
    public Expression getLimit() {
        return limit;
    }
    
    public Expression getOffset() {
        return offset;
    }
    
    public void setTerms(List<OrderingTerm> terms) {
        this.terms = terms;
    }
    
    public void setLimit(Expression limit) {
        this.limit = limit;
    }
    
    public void setOffset(Expression offset) {
        this.offset = offset;
    }
    
    public void addTerm(OrderingTerm term) {
        terms.add(term);
    }
    
    public boolean removeTerm(OrderingTerm term) {
        return terms.remove(term);
    }

}