package main.sqlipa.ast.stmt.event.insert;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.visitor.VoidVisitor;

public class InsertStmtWithValues extends InsertStmt {
    
    public List<Name> columns;
    
    public List<List<Expression>> rows;
    
    public InsertStmtWithValues() {
        super();
    }
    
    public InsertStmtWithValues(InsertStmt stmt) {
        super(stmt, stmt.explain, stmt.type, new Name(stmt.database), new Name(stmt.table));
    }
    
    public InsertStmtWithValues(Block block, Explain explain, Type type, Name database, Name table,
            List<Name> columns, List<List<Expression>> rows) {
        super(block, explain, type, database, table);
        this.columns = columns;
        this.rows = rows;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}