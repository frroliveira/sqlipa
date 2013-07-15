package main.sqlipa.parser.ast.stmt.event.select;

import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.stmt.event.EventStmt;
import main.sqlipa.parser.ast.stmt.event.OrderingTerm;

public class SelectStmt extends EventStmt {

    private SelectCore core;
    
    private Expression limit;
    
    private Expression offset;
    
    private List<CompoundOperation> ops;
    
    private List<OrderingTerm> terms;
    
    public SelectStmt(Block block, Explain explain, SelectCore core,
            Expression limit, Expression offset, List<CompoundOperation> ops,
            List<OrderingTerm> terms) {
        super(block, explain);
        this.core = core;
        this.limit = limit;
        this.offset = offset;
        this.ops = ops;
        this.terms = terms;
    }
    
    public SelectCore getCore() {
        return core;
    }
    
    public Expression getLimit() {
        return limit;
    }
    
    public Expression getOffset() {
        return offset;
    }
    
    public List<CompoundOperation> getOperations() {
        return ops;
    }
    
    public List<OrderingTerm> getTerms() {
        return terms;
    }
    
    public void setCore(SelectCore core) {
        this.core = core;
    }
    
    public void setLimit(Expression limit) {
        this.limit = limit;
    }
    
    public void setOffset(Expression offset) {
        this.offset = offset;
    }
    
    public void setOperations(List<CompoundOperation> ops) {
        this.ops = ops;
    }
    
    public void setTerms(List<OrderingTerm> terms) {
        this.terms = terms;
    }
    
}