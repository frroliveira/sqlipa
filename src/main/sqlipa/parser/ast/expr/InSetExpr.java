package main.sqlipa.parser.ast.expr;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;

public class InSetExpr extends InExpr {

    private List<Expression> set;
    
    public InSetExpr(Block block, Operator op, Expression expr) {
        this(block, op, expr, new LinkedList<Expression>());
    }

    public InSetExpr(Block block, Operator op, Expression expr,
            List<Expression> set) {
        super(block, op, expr);
        this.set = set;
    }
    
    public List<Expression> getSet() {
        return set;
    }
    
    public void setSet(List<Expression> set) {
        this.set = set;
    }
    
}