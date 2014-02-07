package main.sqlipa.ast.stmt;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SqlStmtList extends Node {

    public List<SqlStatement> stmts;
    
    public SqlStmtList() {
        super();
    }
    
    public SqlStmtList(Block block, List<SqlStatement> stmts) {
        super(block);
        this.stmts = stmts;
    }
    
    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }
    
}