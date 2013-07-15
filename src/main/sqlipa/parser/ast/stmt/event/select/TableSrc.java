package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.name.TableAlias;

public class TableSrc extends SingleSrc {
    
    private QualifiedTableName tab;
    
    private TableAlias alias;

    public TableSrc(int beginLine, int beginColumn, int endLine,
            int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
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