package main.sqlipa.ast.constraint.table;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CheckTableConstraint extends TableConstraint {

    public Expression expr;
    
    public CheckTableConstraint() {
        super();
    }
    
    public CheckTableConstraint(Block block, Name name, Expression expr) {
        super(block, name);
        this.expr = expr;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}