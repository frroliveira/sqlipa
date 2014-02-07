package main.sqlipa.ast.stmt.event.delete;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.QualifiedTableName;
import main.sqlipa.ast.expr.Expression;
import main.sqlipa.ast.stmt.event.EventConstraint;
import main.sqlipa.ast.stmt.event.EventStmt;
import main.sqlipa.ast.visitor.VoidVisitor;

public class DeleteStmt extends EventStmt {
    
    public QualifiedTableName qualifiedTable;
    
    public Expression where;
    
    public EventConstraint constraint;

    public DeleteStmt() {
        super();
    }
    
    public DeleteStmt(Block block, Explain explain, QualifiedTableName qualifiedTable,
            Expression where, EventConstraint constraint) {
        super(block, explain);
        this.qualifiedTable = qualifiedTable;
        this.where = where;
        this.constraint = constraint;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}