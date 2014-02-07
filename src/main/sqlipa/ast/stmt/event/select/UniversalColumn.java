package main.sqlipa.ast.stmt.event.select;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class UniversalColumn extends ResultColumn {

    public Name table;
    
    public UniversalColumn() {
        super();
    }
    
    public UniversalColumn(Block block, Name table) {
        super(block);
        this.table = table;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}