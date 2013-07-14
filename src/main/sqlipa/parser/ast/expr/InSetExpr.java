package main.sqlipa.parser.ast.expr;

import java.util.LinkedList;
import java.util.List;

public class InSetExpr extends InExpr {

    private List<Expression> set;
    
    public InSetExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Operator op, Expression expr) {
        this(beginLine, beginColumn, endLine, endColumn, op, expr, 
                new LinkedList<Expression>());
    }

    public InSetExpr(int beginLine, int beginColumn, int endLine,
            int endColumn, Operator op, Expression expr, List<Expression> set) {
        super(beginLine, beginColumn, endLine, endColumn, op, expr);
        this.set = set;
    }
    
    public List<Expression> getSet() {
        return set;
    }
    
    public void setSet(List<Expression> set) {
        this.set = set;
    }
    
}