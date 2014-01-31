package main.sqlipa.parser.ast.visitor;

import main.sqlipa.parser.ast.*;
import main.sqlipa.parser.ast.constraint.*;
import main.sqlipa.parser.ast.constraint.column.*;
import main.sqlipa.parser.ast.constraint.table.*;
import main.sqlipa.parser.ast.expr.*;
import main.sqlipa.parser.ast.literal.*;
import main.sqlipa.parser.ast.stmt.*;
import main.sqlipa.parser.ast.stmt.alter.*;
import main.sqlipa.parser.ast.stmt.create.*;
import main.sqlipa.parser.ast.stmt.drop.*;
import main.sqlipa.parser.ast.stmt.event.*;
import main.sqlipa.parser.ast.stmt.event.delete.*;
import main.sqlipa.parser.ast.stmt.event.insert.*;
import main.sqlipa.parser.ast.stmt.event.select.*;
import main.sqlipa.parser.ast.stmt.event.update.*;
import main.sqlipa.parser.ast.stmt.pragma.*;

public class VoidVisitorAdapter implements VoidVisitor {

    @Override
    public void visit(Node node) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Comment comment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(LineComment comment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BlockComment comment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Name name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(TypeName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(QualifiedTableName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ColumnDef column) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(IndexedBy indexed) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(IndexedColumn indexed) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ModuleArgument arg) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SqlStatement stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(AnalyzeStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(AttachStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BeginStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CommitStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DetachStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ReindexStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ReleaseStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RollbackStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SavepointStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(VacuumStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(AlterTableStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(AddColumnStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RenameTableStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateTableStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateTableStmtWithColumns stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateTableStmtWithSelect stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateIndexStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateViewStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateTriggerStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateVirtualTableStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DropStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DropIndexStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DropTableStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DropTriggerStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DropViewStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(EventStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(EventConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(OrderingTerm term) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DeleteStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InsertStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InsertStmtDefault stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InsertStmtWithSelect stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InsertStmtWithValues stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SelectStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SelectUnit unit) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SelectCore core) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SelectCompound compound) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ResultColumn column) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(AliasedColumn column) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ExpressionColumn column) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(UniversalColumn column) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(JoinConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(JoinConstraintOn constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(JoinConstraintUsing constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(JoinSrc src) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SingleSrc src) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SelectSrc src) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(TableSrc src) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(JoinCompound compound) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(UpdateStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ColumnAssign assign) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PragmaStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PragmaValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PragmaNumber number) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PragmaName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PragmaString string) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Constraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ConflictClause clause) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ForeignKeyClause clause) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ForeignKeySetting sett) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DeferrableSetting sett) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(MatchSetting sett) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(OnSetting sett) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CheckColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CollateColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DefaultColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ForeignKeyColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(NotNullColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PrimaryKeyColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(UniqueColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(TableConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CheckTableConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ForeignKeyTableConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PrimaryKeyTableConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(UniqueTableConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Expression expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BetweenExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BinaryExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BindParameterExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CaseExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CastExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CollateExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ColumnExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(FunctionExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InSelectExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InSetExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(InTableExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(LiteralExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RaiseFunctionExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SelectExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(UnaryExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(WhenExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Literal literal) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BlobLiteral literal) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(NumericLiteral literal) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(StringLiteral literal) {
        // TODO Auto-generated method stub
        
    }
    
}