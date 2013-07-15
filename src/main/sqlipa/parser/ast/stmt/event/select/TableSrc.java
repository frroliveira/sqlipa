package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.name.TableAlias;

public class TableSrc extends SingleSrc {
    
    private QualifiedTableName tab;
    
    private TableAlias alias;

    public TableSrc(Block block) {
        super(block);
    }
    
    public QualifiedTableName getTable() {
        return tab;
    }
    
    public TableAlias getAlias() {
        return alias;
    }
    
    public void setTable(QualifiedTableName tab) {
        this.tab = tab;
    }
    
    public void setAlias(TableAlias alias) {
        this.alias = alias;
    }
    
}