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

public interface VoidVisitor {
    
    // Generic
    public void visit(Node node);

    public void visit(Comment comment);

    public void visit(LineComment comment);

    public void visit(BlockComment comment);

    public void visit(Name name);

    public void visit(TypeName name);
    
    public void visit(QualifiedTableName name);
    
    public void visit(ColumnDef column);

    public void visit(IndexedBy indexed);

    public void visit(IndexedColumn indexed);

    public void visit(ModuleArgument arg);

    // Statements
    public void visit(SqlStatement stmt);
    
    public void visit(AnalyzeStmt stmt);

    public void visit(AttachStmt stmt);
    
    public void visit(BeginStmt stmt);
    
    public void visit(CommitStmt stmt);
    
    public void visit(DetachStmt stmt);
    
    public void visit(ReindexStmt stmt);
    
    public void visit(ReleaseStmt stmt);
    
    public void visit(RollbackStmt stmt);
    
    public void visit(SavepointStmt stmt);
    
    public void visit(VacuumStmt stmt);
        
        // Alter
    public void visit(AlterTableStmt stmt);
    
    public void visit(AddColumnStmt stmt);
    
    public void visit(RenameTableStmt stmt);
    
        // Create
    public void visit(CreateStmt stmt);
    
    public void visit(CreateTableStmt stmt);
    
    public void visit(CreateTableStmtWithColumns stmt);
    
    public void visit(CreateTableStmtWithSelect stmt);
    
    public void visit(CreateIndexStmt stmt);
    
    public void visit(CreateViewStmt stmt);
    
    public void visit(CreateTriggerStmt stmt);
    
    public void visit(CreateVirtualTableStmt stmt);
    
        // Drop
    public void visit(DropStmt stmt);
    
    public void visit(DropIndexStmt stmt);

    public void visit(DropTableStmt stmt);
    
    public void visit(DropTriggerStmt stmt);
    
    public void visit(DropViewStmt stmt);

        // Event
    public void visit(EventStmt stmt);

    public void visit(EventConstraint constraint);
    
    public void visit(OrderingTerm term);
    
            // Delete
    public void visit(DeleteStmt stmt);
    
            // Insert
    public void visit(InsertStmt stmt);
    
    public void visit(InsertStmtDefault stmt);
    
    public void visit(InsertStmtWithSelect stmt);
    
    public void visit(InsertStmtWithValues stmt);
    
            // Select
    public void visit(SelectStmt stmt);

    public void visit(SelectUnit unit);

    public void visit(SelectCore core);

    public void visit(SelectCompound compound);

    public void visit(ResultColumn column);
    
    public void visit(AliasedColumn column);
    
    public void visit(ExpressionColumn column);
    
    public void visit(UniversalColumn column);
    
    public void visit(JoinConstraint constraint);
    
    public void visit(JoinConstraintOn constraint);
    
    public void visit(JoinConstraintUsing constraint);
    
    public void visit(JoinSrc src);
    
    public void visit(SingleSrc src);

    public void visit(SelectSrc src);
    
    public void visit(TableSrc src);

    public void visit(JoinCompound compound);

            // Update
    public void visit(UpdateStmt stmt);
    
    public void visit(ColumnAssign assign);
    
        // Pragma
    public void visit(PragmaStmt stmt);
    
    public void visit(PragmaValue value);
    
    public void visit(PragmaNumber number);
    
    public void visit(PragmaName name);
    
    public void visit(PragmaString string);
    
    // Constraint
    public void visit(Constraint constraint);

    public void visit(ConflictClause clause);

    public void visit(ForeignKeyClause clause);

    public void visit(ForeignKeySetting sett);

    public void visit(DeferrableSetting sett);

    public void visit(MatchSetting sett);

    public void visit(OnSetting sett);

        // Column
    public void visit(ColumnConstraint constraint);

    public void visit(CheckColumnConstraint constraint);

    public void visit(CollateColumnConstraint constraint);

    public void visit(DefaultColumnConstraint constraint);

    public void visit(ForeignKeyColumnConstraint constraint);

    public void visit(NotNullColumnConstraint constraint);

    public void visit(PrimaryKeyColumnConstraint constraint);

    public void visit(UniqueColumnConstraint constraint);

        // Table
    public void visit(TableConstraint constraint);

    public void visit(CheckTableConstraint constraint);

    public void visit(ForeignKeyTableConstraint constraint);

    public void visit(PrimaryKeyTableConstraint constraint);

    public void visit(UniqueTableConstraint constraint);

    // Expression
    public void visit(Expression expr);

    public void visit(BetweenExpr expr);

    public void visit(BinaryExpr expr);

    public void visit(BindParameterExpr expr);

    public void visit(CaseExpr expr);

    public void visit(CastExpr expr);

    public void visit(CollateExpr expr);

    public void visit(ColumnExpr expr);

    public void visit(FunctionExpr expr);

    public void visit(InExpr expr);

    public void visit(InSelectExpr expr);

    public void visit(InSetExpr expr);

    public void visit(InTableExpr expr);

    public void visit(LiteralExpr expr);

    public void visit(RaiseFunctionExpr expr);

    public void visit(SelectExpr expr);

    public void visit(UnaryExpr expr);

    public void visit(WhenExpr expr);

    // Literal
    public void visit(Literal literal);

    public void visit(BlobLiteral literal);

    public void visit(NumericLiteral literal);

    public void visit(StringLiteral literal);

}