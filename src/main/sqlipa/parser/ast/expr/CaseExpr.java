package main.sqlipa.parser.ast.expr;

import java.util.LinkedList;
import java.util.List;

public class CaseExpr extends Expression {
    
    private Expression caseExpr;
    
    private Expression elseExpr;
    
    private List<WhenThenExpr> whenThen;

    public CaseExpr(int beginLine, int beginColumn, int endLine, int endColumn,
            Expression caseExpr, Expression elseExpr) {
        this(beginLine, beginColumn, endLine, endColumn, caseExpr, elseExpr,
                new LinkedList<WhenThenExpr>());
    }
    
    public CaseExpr(int beginLine, int beginColumn, int endLine, int endColumn,
            Expression caseExpr, Expression elseExpr,
            List<WhenThenExpr> whenThen) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.caseExpr = caseExpr;
        this.elseExpr = elseExpr;
        this.whenThen = whenThen;
    }
    
    public Expression getCase() {
        return caseExpr;
    }
    
    public Expression getElse() {
        return elseExpr;
    }
    
    public List<WhenThenExpr> getWhenThen() {
        return whenThen;
    }
    
    public void setCase(Expression caseExpr) {
        this.caseExpr = caseExpr;
    }
    
    public void setElse(Expression elseExpr) {
        this.elseExpr = elseExpr;
    }
    
    public void setWhenThen(List<WhenThenExpr> whenThen) {
        this.whenThen = whenThen;
    }
    
}