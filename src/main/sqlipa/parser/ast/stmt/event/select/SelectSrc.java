package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.TableAlias;

public class SelectSrc extends SingleSrc {

    private SelectStmt stmt;
    
    private TableAlias alias;
    
    public SelectSrc() {
        super();
    }
    
    public SelectSrc(Block block, SelectStmt stmt, TableAlias alias) {
        super(block);
        this.stmt = stmt;
        this.alias = alias;
    }
    
    public SelectStmt getStatement() {
        return stmt;
    }
    
    public TableAlias getAlias() {
        return alias;
    }
    
    public void setStatement(SelectStmt stmt) {
        this.stmt = stmt;
    }
    
    public void setAlias(TableAlias alias) {
        this.alias = alias;
    }
    
}