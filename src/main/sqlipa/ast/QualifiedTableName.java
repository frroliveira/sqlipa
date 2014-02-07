package main.sqlipa.ast;

import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class QualifiedTableName extends Node {

    public Name database;
    
    public Name table;
    
    public IndexedBy indexedBy;
    
    public QualifiedTableName() {
        super();
    }
    
    public QualifiedTableName(Block block, Name database, Name table) {
        super(block);
        this.database = database;
        this.table = table;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}