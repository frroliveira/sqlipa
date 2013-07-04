package sqlipa.parser.ast;

import java.util.List;

import sqlipa.parser.ast.constraint.ColumnConstraint;

public class ColumnDef extends Node {
    
    private String columnName;
    
    private TypeName typeName;
    
    private List<ColumnConstraint> constraints;
}