package main.sqlipa.parser.ast.visitor;

import main.sqlipa.parser.ast.BlockComment;
import main.sqlipa.parser.ast.Comment;
import main.sqlipa.parser.ast.IndexedBy;
import main.sqlipa.parser.ast.IndexedColumn;
import main.sqlipa.parser.ast.LineComment;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.Node;
import main.sqlipa.parser.ast.QualifiedTableName;
import main.sqlipa.parser.ast.constraint.ConflictClause;
import main.sqlipa.parser.ast.constraint.Constraint;
import main.sqlipa.parser.ast.constraint.DeferrableSetting;
import main.sqlipa.parser.ast.constraint.ForeignKeyClause;
import main.sqlipa.parser.ast.constraint.ForeignKeySetting;
import main.sqlipa.parser.ast.constraint.MatchSetting;
import main.sqlipa.parser.ast.constraint.OnSetting;
import main.sqlipa.parser.ast.constraint.column.CheckColumnConstraint;
import main.sqlipa.parser.ast.constraint.column.CollateColumnConstraint;
import main.sqlipa.parser.ast.constraint.column.ColumnConstraint;
import main.sqlipa.parser.ast.constraint.column.DefaultColumnConstraint;
import main.sqlipa.parser.ast.constraint.column.ForeignKeyColumnConstraint;
import main.sqlipa.parser.ast.constraint.column.NotNullColumnConstraint;
import main.sqlipa.parser.ast.constraint.column.PrimaryKeyColumnConstraint;
import main.sqlipa.parser.ast.constraint.column.UniqueColumnConstraint;
import main.sqlipa.parser.ast.constraint.table.CheckTableConstraint;
import main.sqlipa.parser.ast.constraint.table.ForeignKeyTableConstraint;
import main.sqlipa.parser.ast.constraint.table.PrimaryKeyTableConstraint;
import main.sqlipa.parser.ast.constraint.table.TableConstraint;
import main.sqlipa.parser.ast.constraint.table.UniqueTableConstraint;
import main.sqlipa.parser.ast.expr.BetweenExpr;
import main.sqlipa.parser.ast.expr.BinaryExpr;
import main.sqlipa.parser.ast.expr.BindParameterExpr;
import main.sqlipa.parser.ast.expr.CaseExpr;
import main.sqlipa.parser.ast.expr.CastExpr;
import main.sqlipa.parser.ast.expr.CollateExpr;
import main.sqlipa.parser.ast.expr.ColumnExpr;
import main.sqlipa.parser.ast.expr.Expression;
import main.sqlipa.parser.ast.expr.FunctionExpr;
import main.sqlipa.parser.ast.expr.InExpr;
import main.sqlipa.parser.ast.expr.InSelectExpr;
import main.sqlipa.parser.ast.expr.InSetExpr;
import main.sqlipa.parser.ast.expr.InTableExpr;
import main.sqlipa.parser.ast.expr.LiteralExpr;
import main.sqlipa.parser.ast.expr.RaiseFunctionExpr;
import main.sqlipa.parser.ast.expr.SelectExpr;
import main.sqlipa.parser.ast.expr.UnaryExpr;
import main.sqlipa.parser.ast.expr.WhenExpr;
import main.sqlipa.parser.ast.literal.BlobLiteral;
import main.sqlipa.parser.ast.literal.Literal;
import main.sqlipa.parser.ast.literal.NumericLiteral;
import main.sqlipa.parser.ast.literal.StringLiteral;
import main.sqlipa.parser.ast.TypeName;
import main.sqlipa.parser.ast.stmt.SqlStatement;
import main.sqlipa.parser.ast.stmt.create.CreateStmt;
import main.sqlipa.parser.ast.stmt.create.CreateTableStmt;
import main.sqlipa.parser.ast.stmt.create.CreateTableStmtWithColumns;
import main.sqlipa.parser.ast.stmt.create.CreateTableStmtWithSelect;
import main.sqlipa.parser.ast.stmt.event.EventStmt;
import main.sqlipa.parser.ast.stmt.event.OrderingTerm;
import main.sqlipa.parser.ast.stmt.event.select.AliasedColumn;
import main.sqlipa.parser.ast.stmt.event.select.ExpressionColumn;
import main.sqlipa.parser.ast.stmt.event.select.JoinCompound;
import main.sqlipa.parser.ast.stmt.event.select.JoinConstraint;
import main.sqlipa.parser.ast.stmt.event.select.JoinConstraintOn;
import main.sqlipa.parser.ast.stmt.event.select.JoinConstraintUsing;
import main.sqlipa.parser.ast.stmt.event.select.JoinSrc;
import main.sqlipa.parser.ast.stmt.event.select.ResultColumn;
import main.sqlipa.parser.ast.stmt.event.select.SelectCompound;
import main.sqlipa.parser.ast.stmt.event.select.SelectCore;
import main.sqlipa.parser.ast.stmt.event.select.SelectSrc;
import main.sqlipa.parser.ast.stmt.event.select.SelectStmt;
import main.sqlipa.parser.ast.stmt.event.select.SelectUnit;
import main.sqlipa.parser.ast.stmt.event.select.SingleSrc;
import main.sqlipa.parser.ast.stmt.event.select.TableSrc;
import main.sqlipa.parser.ast.stmt.event.select.UniversalColumn;

public interface VoidVisitor {
    
    // Generic
    public void visit(Node node);

    public void visit(Comment comment);

    public void visit(LineComment comment);

    public void visit(BlockComment comment);

    public void visit(IndexedBy indexed);

    public void visit(IndexedColumn indexed);

    public void visit(QualifiedTableName name);

    // Statements
    public void visit(SqlStatement stmt);
    
    public void visit(CreateStmt stmt);
    
    public void visit(CreateTableStmt stmt);
    
    public void visit(CreateTableStmtWithColumns stmt);
    
    public void visit(CreateTableStmtWithSelect stmt);
    
    public void visit(EventStmt stmt);

    public void visit(SelectStmt stmt);
    
    // Event
    public void visit(OrderingTerm term);
    
    // Select
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

    // Constraint
    public void visit(Constraint constraint);

    public void visit(ColumnConstraint constraint);

    public void visit(CheckColumnConstraint constraint);

    public void visit(CollateColumnConstraint constraint);

    public void visit(DefaultColumnConstraint constraint);

    public void visit(ForeignKeyColumnConstraint constraint);

    public void visit(NotNullColumnConstraint constraint);

    public void visit(PrimaryKeyColumnConstraint constraint);

    public void visit(UniqueColumnConstraint constraint);

    public void visit(TableConstraint constraint);

    public void visit(CheckTableConstraint constraint);

    public void visit(ForeignKeyTableConstraint constraint);

    public void visit(PrimaryKeyTableConstraint constraint);

    public void visit(UniqueTableConstraint constraint);

    public void visit(ConflictClause clause);

    public void visit(ForeignKeyClause clause);

    public void visit(ForeignKeySetting sett);

    public void visit(DeferrableSetting sett);

    public void visit(MatchSetting sett);

    public void visit(OnSetting sett);

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

    // Name
    public void visit(Name name);

    public void visit(TypeName name);

}