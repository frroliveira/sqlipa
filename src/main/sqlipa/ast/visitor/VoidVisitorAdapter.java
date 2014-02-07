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
        acceptNode(name.xDimension);
        acceptNode(name.yDimension);
    }

    @Override
    public void visit(QualifiedTableName name) {
        acceptNode(name.database);
        acceptNode(name.table);
        acceptNode(name.indexedBy);
    }

    @Override
    public void visit(ColumnDef column) {
        acceptNode(column.column);
        acceptNode(column.type);
        acceptList(column.constraints);
    }

    @Override
    public void visit(IndexedBy indexed) {
        acceptNode(indexed.index);
    }

    @Override
    public void visit(IndexedColumn indexed) {
        acceptNode(indexed.column);
        acceptNode(indexed.collation);
    }

    @Override
    public void visit(ModuleArgument arg) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visit(SqlStmtList stmtList) {
        acceptList(stmtList.stmts);
    }
    
    @Override
    public void visit(AnalyzeStmt stmt) {
        acceptNode(stmt.first);
        acceptNode(stmt.second);
    }

    @Override
    public void visit(AttachStmt stmt) {
        acceptNode(stmt.expr);
        acceptNode(stmt.database);
    }

    @Override
    public void visit(BeginStmt stmt) {        
    }

    @Override
    public void visit(CommitStmt stmt) {        
    }

    @Override
    public void visit(DetachStmt stmt) {
        acceptNode(stmt.database);
    }

    @Override
    public void visit(ReindexStmt stmt) {
        acceptNode(stmt.first);
        acceptNode(stmt.second);
    }

    @Override
    public void visit(ReleaseStmt stmt) {
        acceptNode(stmt.savepoint);
    }

    @Override
    public void visit(RollbackStmt stmt) {
        acceptNode(stmt.savepoint);        
    }

    @Override
    public void visit(SavepointStmt stmt) {
        acceptNode(stmt.savepoint);        
    }

    @Override
    public void visit(VacuumStmt stmt) {        
    }

    @Override
    public void visit(AddColumnStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.table);
        acceptNode(stmt.column);
    }

    @Override
    public void visit(RenameTableStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.table);
        acceptNode(stmt.newTable);
    }

    @Override
    public void visit(CreateTableStmtWithColumns stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
        acceptList(stmt.columns);
        acceptList(stmt.constraints);
    }

    @Override
    public void visit(CreateTableStmtWithSelect stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
        acceptNode(stmt.select);
    }

    @Override
    public void visit(CreateIndexStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
        acceptNode(stmt.table);
        acceptList(stmt.columns);
    }

    @Override
    public void visit(CreateViewStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
        acceptNode(stmt.select);
    }

    @Override
    public void visit(CreateTriggerStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
        acceptList(stmt.columns);
        acceptNode(stmt.table);
        acceptNode(stmt.when);
        acceptList(stmt.stmts);
    }

    @Override
    public void visit(CreateVirtualTableStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
        acceptNode(stmt.module);
        acceptList(stmt.arguments);
    }

    @Override
    public void visit(DropIndexStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
    }

    @Override
    public void visit(DropTableStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
    }

    @Override
    public void visit(DropTriggerStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
    }

    @Override
    public void visit(DropViewStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.name);
    }

    @Override
    public void visit(EventConstraint constraint) {
        acceptList(constraint.terms);
        acceptNode(constraint.limit);
        acceptNode(constraint.offset);
    }

    @Override
    public void visit(OrderingTerm term) {
        acceptNode(term.expr);
    }

    @Override
    public void visit(DeleteStmt stmt) {
        acceptNode(stmt.qualifiedTable);
        acceptNode(stmt.where);
        acceptNode(stmt.constraint);
    }

    @Override
    public void visit(InsertStmtDefault stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.table);        
    }

    @Override
    public void visit(InsertStmtWithSelect stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.table);
        acceptList(stmt.columns);
        acceptNode(stmt.select);
    }

    @Override
    public void visit(InsertStmtWithValues stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.table);        
        acceptList(stmt.columns);
        if (stmt.rows != null) {
            for (List<? extends Node> row : stmt.rows) {
                acceptList(row);
            }
        }
    }

    @Override
    public void visit(SelectStmt stmt) {
        acceptNode(stmt.unit);
        acceptNode(stmt.constraint);
    }

    @Override
    public void visit(SelectCore core) {
        acceptList(core.columns);
        acceptNode(core.from);
        acceptNode(core.where);
        acceptList(core.groupBy);
        acceptNode(core.having);
    }

    @Override
    public void visit(SelectCompound compound) {
        acceptNode(compound.left);
        acceptNode(compound.right);
    }

    @Override
    public void visit(AliasedColumn column) {
        acceptNode(column.expr);
        acceptNode(column.alias);
    }

    @Override
    public void visit(ExpressionColumn column) {
        acceptNode(column.expr);
    }

    @Override
    public void visit(UniversalColumn column) {
        acceptNode(column.table);
    }

    @Override
    public void visit(JoinConstraintOn constraint) {
        acceptNode(constraint.expr);
    }

    @Override
    public void visit(JoinConstraintUsing constraint) {
        acceptList(constraint.columns);
    }

    @Override
    public void visit(SelectSrc src) {
        acceptNode(src.select);
        acceptNode(src.alias);
    }

    @Override
    public void visit(TableSrc src) {
        acceptNode(src.database);
        acceptNode(src.table);
        acceptNode(src.alias);
        acceptNode(src.indexedBy);
    }

    @Override
    public void visit(JoinCompound compound) {
        acceptNode(compound.left);
        acceptNode(compound.right);
        acceptNode(compound.constraint);
    }

    @Override
    public void visit(UpdateStmt stmt) {
        acceptNode(stmt.qualifiedTable);
        acceptList(stmt.assignments);
        acceptNode(stmt.where);
        acceptNode(stmt.constraint);
    }

    @Override
    public void visit(ColumnAssignment assign) {
        acceptNode(assign.column);
        acceptNode(assign.expr);
    }

    @Override
    public void visit(PragmaStmt stmt) {
        acceptNode(stmt.database);
        acceptNode(stmt.pragma);
        acceptNode(stmt.value);
    }

    @Override
    public void visit(PragmaNumber number) {
        acceptNode(number.number);
    }

    @Override
    public void visit(PragmaName name) {
        acceptNode(name.name);
    }

    @Override
    public void visit(PragmaString string) {
        acceptNode(string.string);
    }

    @Override
    public void visit(ConflictClause clause) {
    }

    @Override
    public void visit(ForeignKeyClause clause) {
        acceptNode(clause.table);
        acceptList(clause.columns);
        acceptList(clause.settings);
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
        acceptNode(constraint.name);
        acceptNode(constraint.expr);
    }

    @Override
    public void visit(CollateColumnConstraint constraint) {
        acceptNode(constraint.name);
        acceptNode(constraint.collation);
    }

    @Override
    public void visit(DefaultColumnConstraint constraint) {
        acceptNode(constraint.name);
        acceptNode(constraint.expr);
    }

    @Override
    public void visit(ForeignKeyColumnConstraint constraint) {
        acceptNode(constraint.name);
        acceptNode(constraint.clause);
    }

    @Override
    public void visit(NotNullColumnConstraint constraint) {
        acceptNode(constraint.name);
        acceptNode(constraint.clause);
    }

    @Override
    public void visit(PrimaryKeyColumnConstraint constraint) {
        acceptNode(constraint.name);
        acceptNode(constraint.clause);
    }

    @Override
    public void visit(UniqueColumnConstraint constraint) {
        acceptNode(constraint.name);
        acceptNode(constraint.clause);
    }

    @Override
    public void visit(CheckTableConstraint constraint) {
        acceptNode(constraint.name);
        acceptNode(constraint.expr);        
    }

    @Override
    public void visit(ForeignKeyTableConstraint constraint) {
        acceptNode(constraint.name);
        acceptList(constraint.columns);
        acceptNode(constraint.clause);
    }

    @Override
    public void visit(PrimaryKeyTableConstraint constraint) {
        acceptNode(constraint.name);
        acceptList(constraint.columns);
        acceptNode(constraint.clause);
    }

    @Override
    public void visit(UniqueTableConstraint constraint) {
        acceptNode(constraint.name);
        acceptList(constraint.columns);
        acceptNode(constraint.clause);        
    }

    @Override
    public void visit(BetweenExpr expr) {
        acceptNode(expr.expr);
        acceptNode(expr.lower);
        acceptNode(expr.upper);
    }

    @Override
    public void visit(BinaryExpr expr) {
        acceptNode(expr.left);
        acceptNode(expr.right);
    }

    @Override
    public void visit(BindParameterExpr expr) {
    }

    @Override
    public void visit(CaseExpr expr) {
        acceptNode(expr.caseExpr);
        acceptList(expr.whens);
        acceptNode(expr.elseExpr);
    }

    @Override
    public void visit(CastExpr expr) {
        acceptNode(expr.expr);
        acceptNode(expr.type);
    }

    @Override
    public void visit(CollateExpr expr) {
        acceptNode(expr.expr);
        acceptNode(expr.collation);
    }

    @Override
    public void visit(ColumnExpr expr) {
        acceptNode(expr.database);
        acceptNode(expr.table);
        acceptNode(expr.column);
    }

    @Override
    public void visit(FunctionExpr expr) {
        acceptNode(expr.function);
        acceptList(expr.exprs);
    }

    @Override
    public void visit(InSelectExpr expr) {
        acceptNode(expr.expr);
        acceptNode(expr.select);
    }

    @Override
    public void visit(InSetExpr expr) {
        acceptNode(expr.expr);
        acceptList(expr.set);
    }

    @Override
    public void visit(InTableExpr expr) {
        acceptNode(expr.expr);
        acceptNode(expr.database);
        acceptNode(expr.table);
    }

    @Override
    public void visit(LiteralExpr expr) {
        acceptNode(expr.literal);
    }

    @Override
    public void visit(RaiseFunctionExpr expr) {
    }

    @Override
    public void visit(SelectExpr expr) {
        acceptNode(expr.select);
    }

    @Override
    public void visit(UnaryExpr expr) {
        acceptNode(expr.expr);
    }

    @Override
    public void visit(WhenExpr expr) {
        acceptNode(expr.when);
        acceptNode(expr.then);
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