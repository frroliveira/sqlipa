package main.sqlipa.ast;

import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class QualifiedTableName extends Node {

    private Name database;
    
    private Name table;
    
    private IndexedBy indexed;
    
    public QualifiedTableName() {
        super();
    }
    
    public QualifiedTableName(Block block, Name database, Name table) {
        super(block);
        this.database = database;
        this.table = table;
    }
    
    public Name getDatabase() {
        return database;
    }
    
    public Name getTable() {
        return table;
    }
    
    public IndexedBy getIndexed() {
        return indexed;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }
    
    public void setIndexed(IndexedBy indexed) {
        this.indexed = indexed;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}