package main.sqlipa.ast.stmt.create;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.IndexedColumn;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateIndexStmt extends CreateStmt {
    
    public boolean hasUnique;
    
    public Name table;
    
    public List<IndexedColumn> columns;
    
    public CreateIndexStmt() {
        super();
    }
    
    public CreateIndexStmt(Block block, Explain explain, boolean hasIfNotExists, Name database,
            Name name, boolean hasUnique, Name table, List<IndexedColumn> columns) {
        super(block, explain, hasIfNotExists, database, name);
        this.hasUnique = hasUnique;
        this.table = table;
        this.columns = columns;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}