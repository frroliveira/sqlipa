package main.sqlipa.parser.ast;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.constraint.ColumnConstraint;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.TypeName;

public class ColumnDef extends Node {
    
    private ColumnName column;
    
    private TypeName type;
    
    private List<ColumnConstraint> constraints;
    
    public ColumnDef(int beginLine, int beginColumn, int endLine, int endColumn, 
            ColumnName column, TypeName type) {
        this(beginLine, beginColumn, endLine, endColumn, column, type, 
                new LinkedList<ColumnConstraint>());
    }
    
    public ColumnDef(int beginLine, int beginColumn, int endLine, int endColumn, 
            ColumnName column, TypeName type, 
            List<ColumnConstraint> constraints) {
        super(beginLine, beginColumn, endLine, endColumn);
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
    
    public void removeConstraint(ColumnConstraint constraint) {
        constraints.remove(constraint);
    }

}