package main.sqlipa.parser.ast.visitor;

import main.sqlipa.parser.ast.BlockComment;
import main.sqlipa.parser.ast.Comment;
import main.sqlipa.parser.ast.IndexedBy;
import main.sqlipa.parser.ast.IndexedColumn;
import main.sqlipa.parser.ast.LineComment;
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
import main.sqlipa.parser.ast.name.Alias;
import main.sqlipa.parser.ast.name.CollationName;
import main.sqlipa.parser.ast.name.ColumnAlias;
import main.sqlipa.parser.ast.name.ColumnName;
import main.sqlipa.parser.ast.name.ConstraintName;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.FunctionName;
import main.sqlipa.parser.ast.name.IndexName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.name.TableAlias;
import main.sqlipa.parser.ast.name.TableName;
import main.sqlipa.parser.ast.name.TypeName;
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

public class DumpVisitor implements VoidVisitor {

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
    public void visit(IndexedBy indexed) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(IndexedColumn indexed) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(QualifiedTableName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SqlStatement stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CreateStmt stmt) {
        System.out.println("CREATE");
    }

    @Override
    public void visit(CreateTableStmt stmt) {
        visit((CreateStmt) stmt);
        if (stmt.hasTemporary()) {
            System.out.println(" TEMP");
        }
        System.out.println(" TABLE");
        if (stmt.hasIfNotExists()) {
            System.out.println(" IF NOT EXISTS");
        }
        System.out.println(" ");
        visit(stmt.getDatabase());
        System.out.println(".");
        visit(stmt.getName());
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
    public void visit(EventStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SelectStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(OrderingTerm term) {
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
    public void visit(Constraint constraint) {
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

    @Override
    public void visit(Name name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CollationName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ColumnName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ConstraintName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(DatabaseName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(FunctionName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(IndexName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(TableName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(TypeName name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Alias alias) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ColumnAlias alias) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(TableAlias alias) {
        // TODO Auto-generated method stub
        
    }
    
}