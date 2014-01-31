package main.sqlipa.parser.ast.stmt.event.select;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public class UniversalColumn extends ResultColumn {

    private Name table;
    
    public UniversalColumn() {
        super();
    }
    
    public UniversalColumn(Block block, Name table) {
        super(block);
        this.table = table;
    }
    
    public Name getTable() {
        return table;
    }
    
    public void setTable(Name table) {
        this.table = table;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}