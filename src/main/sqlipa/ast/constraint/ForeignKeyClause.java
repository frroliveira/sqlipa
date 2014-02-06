package main.sqlipa.ast.constraint;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ForeignKeyClause extends Node {
    
    private Name table;
    
    private List<Name> columns;
    
    private List<ForeignKeySetting> settings;
    
    public ForeignKeyClause() {
        super();
        this.columns = new LinkedList<Name>();
        this.settings = new LinkedList<ForeignKeySetting>();
    }

    public ForeignKeyClause(Block block, Name table, List<Name> columns,
            List<ForeignKeySetting> settings) {
        super(block);
        this.table = table;
        this.columns = columns;
        this.settings = settings;
    }
    
    public Name getTable() {
        return table;
    }
    
    public List<Name> getColumns() {
        return columns;
    }
    
    public List<ForeignKeySetting> getSettings() {
        return settings;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }
    
    public void setColumns(List<Name> columns) {
        this.columns = columns;
    }
    
    public void setSettings(List<ForeignKeySetting> settings) {
        this.settings = settings;
    }
    
    public void addColumn(Name column) {
        columns.add(column);
    }
    
    public void addSetting(ForeignKeySetting setting) {
        settings.add(setting);
    }
    
    public void removeColumn(Name column) {
        columns.remove(column);
    }
    
    public void removeSetting(ForeignKeySetting setting) {
        settings.remove(setting);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}