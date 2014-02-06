package main.sqlipa.ast.stmt;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.visitor.VoidVisitor;

public class SqlStmtList extends Node {

    public List<SqlStatement> stmts;
    
    public SqlStmtList() {
        super();
        this.stmts = new LinkedList<SqlStatement>();
    }
    
    public SqlStmtList(Block block, List<SqlStatement> stmts) {
        super(block);
        this.stmts = stmts;
    }
    
    public List<SqlStatement> getStatements() {
        return stmts;
    }
    
    public void setStatements(List<SqlStatement> stmts) {
        this.stmts = stmts;
    }
    
    public void addStatement(SqlStatement stmt) {
        stmts.add(stmt);
    }
    
    public boolean removeStatement(SqlStatement stmt) {
        return stmts.remove(stmt);
    }
    
    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }
    
}