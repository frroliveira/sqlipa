package main.sqlipa.parser.ast.constraint.table;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.visitor.VoidVisitor;
import main.sqlipa.parser.ast.Name;

public class CheckTableConstraint extends TableConstraint {

    private Expression expr;
    
    public CheckTableConstraint() {
        super();
    }
    
    public CheckTableConstraint(Block block, Name name, Expression expr) {
        super(block, name);
        this.expr = expr;
    }
    
    public Expression getExpression() {
        return expr;
    }
    
    public void setExpression(Expression expr) {
        this.expr = expr;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}