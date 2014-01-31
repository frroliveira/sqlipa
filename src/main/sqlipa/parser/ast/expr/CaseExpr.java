package main.sqlipa.parser.ast.expr;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class CaseExpr extends Expression {
    
    private Expression caseExpr;
    
    private Expression elseExpr;
    
    private List<WhenExpr> whens;

    public CaseExpr() {
        super();
        this.whens = new LinkedList<WhenExpr>();
    }
    
    public CaseExpr(Block block, Expression caseExpr, Expression elseExpr,
            List<WhenExpr> when) {
        super(block);
        this.caseExpr = caseExpr;
        this.elseExpr = elseExpr;
        this.whens = when;
    }
    
    public Expression getCase() {
        return caseExpr;
    }
    
    public Expression getElse() {
        return elseExpr;
    }
    
    public List<WhenExpr> getWhens() {
        return whens;
    }
    
    public void setCase(Expression caseExpr) {
        this.caseExpr = caseExpr;
    }
    
    public void setElse(Expression elseExpr) {
        this.elseExpr = elseExpr;
    }
    
    public void setWhens(List<WhenExpr> whens) {
        this.whens = whens;
    }
    
    public void addWhen(WhenExpr when) {
        whens.add(when);
    }
    
    public boolean removeWhen(WhenExpr when) {
        return whens.remove(when);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}