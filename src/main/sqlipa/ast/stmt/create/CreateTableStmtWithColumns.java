package main.sqlipa.ast.stmt.create;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.ColumnDef;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.constraint.table.TableConstraint;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateTableStmtWithColumns extends CreateTableStmt {

    public List<ColumnDef> columns;
    
    public List<TableConstraint> constraints;
    
    public CreateTableStmtWithColumns() {
        super();
    }
    
    public CreateTableStmtWithColumns(CreateTableStmt stmt) {
        super(stmt, stmt.explain, stmt.hasIfNotExists, new Name(stmt.database), new Name(stmt.name),
                stmt.hasTemporary);
    }
    
    public CreateTableStmtWithColumns(Block block, Explain explain, boolean hasIfNotExists, 
            Name database, Name name, boolean hasTemporary, List<ColumnDef> columns,
            List<TableConstraint> constraints) {
        super(block, explain, hasIfNotExists, database, name, hasTemporary);
        this.columns = columns;
        this.constraints = constraints;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}