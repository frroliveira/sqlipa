package main.sqlipa.parser.ast;

import java.util.List;

import main.sqlipa.parser.ast.constraint.column.ColumnConstraint;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.TypeName;

public class ColumnDef extends Node {
    
    private ColumnName column;
    
    private TypeName type;
    
    private List<ColumnConstraint> constraints;
    
    public ColumnDef() {
        super();
    }
    
    public ColumnDef(Block block, ColumnName column, TypeName type, 
            List<ColumnConstraint> constraints) {
        super(block);
        this.column = column;
        this.type = type;
        this.constraints = constraints;
    }
    
    public ColumnName getColumn() {
        return column;
    }
    
    public TypeName getType() {
        return type;
    }
    
    public List<ColumnConstraint> getConstraints() {
        return constraints;
    }
    
    public void setColumn(ColumnName column) {
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

}