package main.sqlipa.ast.expr;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CaseExpr extends Expression {
    
    public Expression caseExpr;
    
    public Expression elseExpr;
    
    public List<WhenExpr> whens;

    public CaseExpr() {
        super();
    }
    
    public CaseExpr(Block block, Expression caseExpr, Expression elseExpr, List<WhenExpr> whens) {
        super(block);
        this.caseExpr = caseExpr;
        this.elseExpr = elseExpr;
        this.whens = whens;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}