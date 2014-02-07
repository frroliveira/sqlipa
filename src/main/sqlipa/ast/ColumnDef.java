package main.sqlipa.ast;

import java.util.List;

import main.sqlipa.ast.constraint.column.ColumnConstraint;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ColumnDef extends Node {
    
    public Name column;
    
    public TypeName type;
    
    public List<ColumnConstraint> constraints;
    
    public ColumnDef() {
        super();
    }
    
    public ColumnDef(Block block, Name column, TypeName type, List<ColumnConstraint> constraints) {
        super(block);
        this.column = column;
        this.type = type;
        this.constraints = constraints;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}