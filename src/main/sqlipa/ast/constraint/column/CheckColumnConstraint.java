package main.sqlipa.ast.constraint.column;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CheckColumnConstraint extends ColumnConstraint {

    public Expression expr;

    public CheckColumnConstraint() {
        super();
    }
    
    public CheckColumnConstraint(Block block, Name name, Expression expr) {
        super(block, name);
        this.expr = expr;
    }
    
    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}