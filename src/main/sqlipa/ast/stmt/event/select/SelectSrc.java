package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SelectSrc extends SingleSrc {

    private SelectStmt select;
    
    private Name alias;
    
    public SelectSrc() {
        super();
    }
    
    public SelectSrc(Block block, SelectStmt select, Name alias) {
        super(block);
        this.select = select;
        this.alias = alias;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public Name getAlias() {
        return alias;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }
    
    public void setAlias(Name alias) {
        this.alias = alias;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}