package main.sqlipa.ast.visitor;

import java.util.List;

import main.sqlipa.ast.*;
import main.sqlipa.ast.constraint.*;
import main.sqlipa.ast.constraint.column.*;
import main.sqlipa.ast.constraint.table.*;
import main.sqlipa.ast.expr.*;
import main.sqlipa.ast.literal.*;
import main.sqlipa.ast.stmt.*;
import main.sqlipa.ast.stmt.alter.*;
import main.sqlipa.ast.stmt.create.*;
import main.sqlipa.ast.stmt.drop.*;
import main.sqlipa.ast.stmt.event.*;
import main.sqlipa.ast.stmt.event.delete.*;
import main.sqlipa.ast.stmt.event.insert.*;
import main.sqlipa.ast.stmt.event.select.*;
import main.sqlipa.ast.stmt.event.update.*;
import main.sqlipa.ast.stmt.pragma.*;

public abstract class VoidVisitorAdapter implements VoidVisitor {

    private void acceptNode(Node node) {
        if (node != null) {
            node.accept(this);
        }
    }
    
    private void acceptList(List<? extends Node> nodes) {
        if (nodes != null) {
            for (Node node : nodes) {
                node.accept(this);
            }
        }
    }

    @Override
    public void visit(LineComment comment) {
    }

    @Override
    public void visit(BlockComment comment) {
    }

    @Override
    public void visit(Name name) {       
    }

    @Override
    public void visit(TypeName name) {
        visit((Name) name);
        acceptNode(name.getDimensionInX());
        acceptNode(name.getDimensionInY());
    }

    @Override
    public void visit(QualifiedTableName name) {
        acceptNode(name.getDatabase());
        acceptNode(name.getTable());
        acceptNode(name.getIndexed());
    }

    @Override
    public void visit(ColumnDef column) {
        acceptNode(column.getColumn());
        acceptNode(column.getType());
        acceptList(column.getConstraints());
    }

    @Override
    public void visit(IndexedBy indexed) {
        acceptNode(indexed.getIndex());
    }

    @Override
    public void visit(IndexedColumn indexed) {
        acceptNode(indexed.getColumn());
        acceptNode(indexed.getCollation());
    }

    @Override
    public void visit(ModuleArgument arg) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visit(SqlStmtList stmtList) {
        acceptList(stmtList.getStatements());
    }
    
    @Override
    public void visit(AnalyzeStmt stmt) {
        acceptNode(stmt.getFirstName());
        acceptNode(stmt.getSecondName());
    }

    @Override
    public void visit(AttachStmt stmt) {
        acceptNode(stmt.getExpression());
        acceptNode(stmt.getDatabase());
    }

    @Override
    public void visit(BeginStmt stmt) {        
    }

    @Override
    public void visit(CommitStmt stmt) {        
    }

    @Override
    public void visit(DetachStmt stmt) {
        acceptNode(stmt.getDatabase());
    }

    @Override
    public void visit(ReindexStmt stmt) {
        acceptNode(stmt.getFirst());
        acceptNode(stmt.getSecond());
    }

    @Override
    public void visit(ReleaseStmt stmt) {
        acceptNode(stmt.getSavepoint());
    }

    @Override
    public void visit(RollbackStmt stmt) {
        acceptNode(stmt.getSavepoint());        
    }

    @Override
    public void visit(SavepointStmt stmt) {
        acceptNode(stmt.getSavepoint());        
    }

    @Override
    public void visit(VacuumStmt stmt) {        
    }

    @Override
    public void visit(AddColumnStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getTable());
        acceptNode(stmt.getColumn());
    }

    @Override
    public void visit(RenameTableStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getTable());
        acceptNode(stmt.getNewTable());
    }

    @Override
    public void visit(CreateTableStmtWithColumns stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
        acceptList(stmt.getColumns());
        acceptList(stmt.getConstraints());
    }

    @Override
    public void visit(CreateTableStmtWithSelect stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
        acceptNode(stmt.getSelect());
    }

    @Override
    public void visit(CreateIndexStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
        acceptNode(stmt.getTable());
        acceptList(stmt.getColumns());
    }

    @Override
    public void visit(CreateViewStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
        acceptNode(stmt.getSelect());
    }

    @Override
    public void visit(CreateTriggerStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
        acceptList(stmt.getColumns());
        acceptNode(stmt.getTable());
        acceptNode(stmt.getWhen());
        acceptList(stmt.getStatements());
    }

    @Override
    public void visit(CreateVirtualTableStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
        acceptNode(stmt.getModule());
        acceptList(stmt.getModuleArguments());
    }

    @Override
    public void visit(DropIndexStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
    }

    @Override
    public void visit(DropTableStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
    }

    @Override
    public void visit(DropTriggerStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
    }

    @Override
    public void visit(DropViewStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getName());
    }

    @Override
    public void visit(EventConstraint constraint) {
        acceptList(constraint.getTerms());
        acceptNode(constraint.getLimit());
        acceptNode(constraint.getOffset());
    }

    @Override
    public void visit(OrderingTerm term) {
        acceptNode(term.getExpression());
    }

    @Override
    public void visit(DeleteStmt stmt) {
        acceptNode(stmt.getQualifiedTable());
        acceptNode(stmt.getWhere());
        acceptNode(stmt.getConstraint());
    }

    @Override
    public void visit(InsertStmtDefault stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getTable());        
    }

    @Override
    public void visit(InsertStmtWithSelect stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getTable());
        acceptList(stmt.getColumns());
        acceptNode(stmt.getSelect());
    }

    @Override
    public void visit(InsertStmtWithValues stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getTable());        
        acceptList(stmt.getColumns());
        if (stmt.getRows() != null) {
            for (List<? extends Node> row : stmt.getRows()) {
                acceptList(row);
            }
        }
    }

    @Override
    public void visit(SelectStmt stmt) {
        acceptNode(stmt.getUnit());
        acceptNode(stmt.getConstraint());
    }

    @Override
    public void visit(SelectCore core) {
        acceptList(core.getColumns());
        acceptNode(core.getFrom());
        acceptNode(core.getWhere());
        acceptList(core.getGroupBy());
        acceptNode(core.getHaving());
    }

    @Override
    public void visit(SelectCompound compound) {
        acceptNode(compound.getLeft());
        acceptNode(compound.getRight());
    }

    @Override
    public void visit(AliasedColumn column) {
        acceptNode(column.getExpression());
        acceptNode(column.getAlias());
    }

    @Override
    public void visit(ExpressionColumn column) {
        acceptNode(column.getExpression());
    }

    @Override
    public void visit(UniversalColumn column) {
        acceptNode(column.getTable());
    }

    @Override
    public void visit(JoinConstraintOn constraint) {
        acceptNode(constraint.getExpression());
    }

    @Override
    public void visit(JoinConstraintUsing constraint) {
        acceptList(constraint.getColumns());
    }

    @Override
    public void visit(SelectSrc src) {
        acceptNode(src.getSelect());
        acceptNode(src.getAlias());
    }

    @Override
    public void visit(TableSrc src) {
        acceptNode(src.getDatabase());
        acceptNode(src.getTable());
        acceptNode(src.getAlias());
        acceptNode(src.getIndexed());
    }

    @Override
    public void visit(JoinCompound compound) {
        acceptNode(compound.getLeft());
        acceptNode(compound.getRight());
        acceptNode(compound.getConstraint());
    }

    @Override
    public void visit(UpdateStmt stmt) {
        acceptNode(stmt.getQualifiedTable());
        acceptList(stmt.getAssignments());
        acceptNode(stmt.getWhere());
        acceptNode(stmt.getConstraint());
    }

    @Override
    public void visit(ColumnAssign assign) {
        acceptNode(assign.getColumn());
        acceptNode(assign.getExpr());
    }

    @Override
    public void visit(PragmaStmt stmt) {
        acceptNode(stmt.getDatabase());
        acceptNode(stmt.getPragma());
        acceptNode(stmt.getValue());
    }

    @Override
    public void visit(PragmaNumber number) {
        acceptNode(number.getNumber());
    }

    @Override
    public void visit(PragmaName name) {
        acceptNode(name.getName());
    }

    @Override
    public void visit(PragmaString string) {
        acceptNode(string.getString());
    }

    @Override
    public void visit(ConflictClause clause) {
    }

    @Override
    public void visit(ForeignKeyClause clause) {
        acceptNode(clause.getTable());
        acceptList(clause.getColumns());
        acceptList(clause.getSettings());
    }

    @Override
    public void visit(DeferrableSetting sett) {        
    }

    @Override
    public void visit(MatchSetting sett) {        
    }

    @Override
    public void visit(OnSetting sett) {        
    }

    @Override
    public void visit(CheckColumnConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getExpression());
    }

    @Override
    public void visit(CollateColumnConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getCollation());
    }

    @Override
    public void visit(DefaultColumnConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getExpression());
    }

    @Override
    public void visit(ForeignKeyColumnConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getClause());
    }

    @Override
    public void visit(NotNullColumnConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getClause());
    }

    @Override
    public void visit(PrimaryKeyColumnConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getClause());
    }

    @Override
    public void visit(UniqueColumnConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getClause());
    }

    @Override
    public void visit(CheckTableConstraint constraint) {
        acceptNode(constraint.getName());
        acceptNode(constraint.getExpression());        
    }

    @Override
    public void visit(ForeignKeyTableConstraint constraint) {
        acceptNode(constraint.getName());
        acceptList(constraint.getColumns());
        acceptNode(constraint.getClause());
    }

    @Override
    public void visit(PrimaryKeyTableConstraint constraint) {
        acceptNode(constraint.getName());
        acceptList(constraint.getColumns());
        acceptNode(constraint.getClause());
    }

    @Override
    public void visit(UniqueTableConstraint constraint) {
        acceptNode(constraint.getName());
        acceptList(constraint.getColumns());
        acceptNode(constraint.getClause());        
    }

    @Override
    public void visit(BetweenExpr expr) {
        acceptNode(expr.getExpression());
        acceptNode(expr.getLower());
        acceptNode(expr.getUpper());
    }

    @Override
    public void visit(BinaryExpr expr) {
        acceptNode(expr.getLeft());
        acceptNode(expr.getRight());
    }

    @Override
    public void visit(BindParameterExpr expr) {
    }

    @Override
    public void visit(CaseExpr expr) {
        acceptNode(expr.getCase());
        acceptList(expr.getWhens());
        acceptNode(expr.getElse());
    }

    @Override
    public void visit(CastExpr expr) {
        acceptNode(expr.getExpression());
        acceptNode(expr.getType());
    }

    @Override
    public void visit(CollateExpr expr) {
        acceptNode(expr.getExpression());
        acceptNode(expr.getCollation());
    }

    @Override
    public void visit(ColumnExpr expr) {
        acceptNode(expr.getDatabase());
        acceptNode(expr.getTable());
        acceptNode(expr.getColumn());
    }

    @Override
    public void visit(FunctionExpr expr) {
        acceptNode(expr.getFunction());
        acceptList(expr.getExpressions());
    }

    @Override
    public void visit(InSelectExpr expr) {
        acceptNode(expr.getExpression());
        acceptNode(expr.getSelect());
    }

    @Override
    public void visit(InSetExpr expr) {
        acceptNode(expr.getExpression());
        acceptList(expr.getSet());
    }

    @Override
    public void visit(InTableExpr expr) {
        acceptNode(expr.getExpression());
        acceptNode(expr.getDatabase());
        acceptNode(expr.getTable());
    }

    @Override
    public void visit(LiteralExpr expr) {
        acceptNode(expr.getLiteral());
    }

    @Override
    public void visit(RaiseFunctionExpr expr) {
    }

    @Override
    public void visit(SelectExpr expr) {
        acceptNode(expr.getSelect());
    }

    @Override
    public void visit(UnaryExpr expr) {
        acceptNode(expr.getExpression());
    }

    @Override
    public void visit(WhenExpr expr) {
        acceptNode(expr.getWhen());
        acceptNode(expr.getThen());
    }

    @Override
    public void visit(Literal literal) {
    }

    @Override
    public void visit(BlobLiteral literal) {        
    }

    @Override
    public void visit(NumericLiteral literal) {
    }

    @Override
    public void visit(StringLiteral literal) {
    }

}