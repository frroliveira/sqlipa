package main.sqlipa.ast.constraint;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ForeignKeyClause extends Node {
    
    public Name table;
    
    public List<Name> columns;
    
    public List<ForeignKeySetting> settings;
    
    public ForeignKeyClause() {
        super();
    }

    public ForeignKeyClause(Block block, Name table, List<Name> columns,
            List<ForeignKeySetting> settings) {
        super(block);
        this.table = table;
        this.columns = columns;
        this.settings = settings;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}