package main.sqlipa.ast;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.ast.constraint.column.ColumnConstraint;
import main.sqlipa.ast.visitor.VoidVisitor;

public class ColumnDef extends Node {
    
    private Name column;
    
    private TypeName type;
    
    private List<ColumnConstraint> constraints;
    
    public ColumnDef() {
        super();
        this.constraints = new LinkedList<ColumnConstraint>();
    }
    
    public ColumnDef(Block block, Name column, TypeName type, 
            List<ColumnConstraint> constraints) {
        super(block);
        this.column = column;
        this.type = type;
        this.constraints = constraints;
    }
    
    public Name getColumn() {
        return column;
    }
    
    public TypeName getType() {
        return type;
    }
    
    public List<ColumnConstraint> getConstraints() {
        return constraints;
    }
    
    public void setColumn(Name column) {
        this.column = column;
    }
    
    public void setType(TypeName type) {
        this.type = type;
    }
    
    public void setConstraints(List<ColumnConstraint> constraints) {
        this.constraints = constraints;
    }
    
    public void addConstraint(ColumnConstraint constraint) {
        constraints.add(constraint);
    }
    
    public boolean removeConstraint(ColumnConstraint constraint) {
        return constraints.remove(constraint);
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}