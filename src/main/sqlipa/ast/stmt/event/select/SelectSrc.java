package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SelectSrc extends SingleSrc {

    public SelectStmt select;
    
    public Name alias;
    
    public SelectSrc() {
        super();
    }
    
    public SelectSrc(Block block, SelectStmt select, Name alias) {
        super(block);
        this.select = select;
        this.alias = alias;
    }
    
    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}