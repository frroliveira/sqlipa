package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.TableName;

public class UniversalColumn extends ResultColumn {

    private TableName tab;
    
    public UniversalColumn() {
        super();
    }
    
    public UniversalColumn(Block block, TableName tab) {
        super(block);
        this.tab = tab;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }

}