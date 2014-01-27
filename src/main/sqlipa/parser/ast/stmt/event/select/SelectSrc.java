package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.TableAlias;

public class SelectSrc extends SingleSrc {

    private SelectStmt select;
    
    private TableAlias alias;
    
    public SelectSrc() {
        super();
    }
    
    public SelectSrc(Block block, SelectStmt select, TableAlias alias) {
        super(block);
        this.select = select;
        this.alias = alias;
    }
    
    public SelectStmt getSelect() {
        return select;
    }
    
    public TableAlias getAlias() {
        return alias;
    }
    
    public void setSelect(SelectStmt select) {
        this.select = select;
    }
    
    public void setAlias(TableAlias alias) {
        this.alias = alias;
    }
    
}