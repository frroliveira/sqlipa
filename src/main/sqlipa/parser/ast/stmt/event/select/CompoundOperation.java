package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;

public class CompoundOperation extends Node {
    
    public enum Operator {
        UNION,
        UNION_ALL,
        INTERSECT,
        EXCEPT
    }
    
    private Operator op;
    
    private SelectCore core;
    
    public CompoundOperation(Block block, Operator op, SelectCore core) {
        super(block);
        this.op = op;
        this.core = core;
    }
    
    public Operator getOperator() {
        return op;
    }
    
    public SelectCore getCore() {
        return core;
    }
    
    public void setOperator(Operator op) {
        this.op = op;
    }
    
    public void setCore(SelectCore core) {
        this.core = core;
    }
    
}