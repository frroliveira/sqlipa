package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class ConflictClause extends Node {
    
    public enum Action {
        ROLLBACK,
        ABORT,
        FAIL,
        IGNORE,
        REPLACE
    }

    private Action action;
    
    public ConflictClause() {
        super();
    }
    
    public ConflictClause(Block block, Action action) {
        super(block);
        this.action = action;
    }
    
    public Action getAction() {
        return action;
    }
    
    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}