package sqlipa.parser.ast.stmt;

import java.util.List;

import sqlipa.parser.ast.ColumnDef;
import sqlipa.parser.ast.constraint.TableConstraint;

public class CreateTableStmt extends Statement {
    
    private boolean temporary;
    
    private String databaseName;
    
    private String tableName;
    
    private List<ColumnDef> columns;
    
    private List<TableConstraint> constraints;
}