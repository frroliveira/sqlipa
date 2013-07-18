package main.sqlipa.parser.ast.constraint;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.TableName;

public class ForeignKeyClause extends Node {
    
    private TableName tab;
    
    private List<ColumnName> columns;
    
    private List<ForeignKeySetting> settings;
    
    public ForeignKeyClause() {
        super();
        this.columns = new LinkedList<ColumnName>();
        this.settings = new LinkedList<ForeignKeySetting>();
    }

    public ForeignKeyClause(Block block, TableName tab,
            List<ColumnName> columns, List<ForeignKeySetting> settings) {
        super(block);
        this.tab = tab;
        this.columns = columns;
        this.settings = settings;
    }
    
    public TableName getTable() {
        return tab;
    }
    
    public List<ColumnName> getColumns() {
        return columns;
    }
    
    public List<ForeignKeySetting> getSettings() {
        return settings;
    }
    
    public void setTable(TableName tab) {
        this.tab = tab;
    }
    
    public void setColumns(List<ColumnName> columns) {
        this.columns = columns;
    }
    
    public void setSettings(List<ForeignKeySetting> settings) {
        this.settings = settings;
    }
    
    public void addColumn(ColumnName column) {
        columns.add(column);
    }
    
    public void addSetting(ForeignKeySetting setting) {
        settings.add(setting);
    }
    
    public void removeColumn(ColumnName column) {
        columns.remove(column);
    }
    
    public void removeSetting(ForeignKeySetting setting) {
        settings.remove(setting);
    }
    
}