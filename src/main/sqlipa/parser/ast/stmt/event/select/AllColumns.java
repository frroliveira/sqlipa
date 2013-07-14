package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.name.TableName;

public class AllColumns extends ResultColumns {

    private TableName tab;
    
    public AllColumns(int beginLine, int beginColumn, int endLine,
            int endColumn, TableName tab) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.tab = tab;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
}