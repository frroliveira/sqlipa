package main.sqlipa.ast.visitor;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import main.sqlipa.ast.*;
import main.sqlipa.ast.constraint.*;
import main.sqlipa.ast.constraint.column.*;
import main.sqlipa.ast.constraint.column.PrimaryKeyColumnConstraint.Order;
import main.sqlipa.ast.constraint.table.*;
import main.sqlipa.ast.expr.*;
import main.sqlipa.ast.literal.*;
import main.sqlipa.ast.stmt.*;
import main.sqlipa.ast.stmt.SqlStatement.Explain;
import main.sqlipa.ast.stmt.alter.*;
import main.sqlipa.ast.stmt.create.*;
import main.sqlipa.ast.stmt.drop.*;
import main.sqlipa.ast.stmt.event.*;
import main.sqlipa.ast.stmt.event.delete.*;
import main.sqlipa.ast.stmt.event.insert.*;
import main.sqlipa.ast.stmt.event.select.*;
import main.sqlipa.ast.stmt.event.update.*;
import main.sqlipa.ast.stmt.pragma.*;

public class SourcePrinterVisitor implements VoidVisitor {

    private PrintStream mStream;
    
    /**
     * Constructs a new SourcePrinterVisitor that can print to a specified stream.
     */
    public SourcePrinterVisitor(PrintStream stream) {
        mStream = stream;
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
        print(name.name);
        print(" ");
    }

    @Override
    public void visit(TypeName name) {
        print(name.name);
        if (name.xDimension != null) {
            print("(");
            name.xDimension.accept(this);
            if (name.yDimension != null) {
                print(",");
                name.yDimension.accept(this);
            }
            print(")");
        }        
    }

    @Override
    public void visit(QualifiedTableName name) {
    	printNode(name.database, ".", false);
    	printNode(name.table);
    	printNode(name.indexedBy);
    }

    @Override
    public void visit(ColumnDef column) {
        printNode(column.column);
        printNode(column.type);
        printList(column.constraints);
    }

    @Override
    public void visit(IndexedBy indexed) {
    	printIf("INDEXED BY ", indexed.index != null);
    	printNode(indexed.index);
    	printIf("NOT INDEXED ", indexed.notIndexed);
	}

    @Override
    public void visit(IndexedColumn indexed) {
    	printNode(indexed.column);
    	printNode(indexed.collation, "COLLATE", true);
    	printIf("ASC", indexed.order == IndexedColumn.Order.ASC);
    	printIf("DESC", indexed.order == IndexedColumn.Order.DESC);
    }

    @Override
    public void visit(ModuleArgument arg) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(SqlStmtList stmtList) {
        printList(stmtList.stmts);
    }

    private void visit(SqlStatement stmt) {
        Explain explain = stmt.explain;
        printIf("EXPLAIN ", explain != null);
        printIf("QUERY PLAN ", explain == Explain.PLAN);
    }

    @Override
    public void visit(AnalyzeStmt stmt) {
        visit((SqlStatement) stmt);
        print("ANALYZE ");
        printNode(stmt.first);
        printNode(stmt.second, ".", true);
    }

    @Override
    public void visit(AttachStmt stmt) {
        visit((SqlStatement) stmt);
        print("ATTACH ");
        printIf("DATABASE ", stmt.hasDatabase);
        printNode(stmt.expr);
        print("AS ");
        printNode(stmt.database);
    }

    @Override
    public void visit(BeginStmt stmt) {
        visit((SqlStatement) stmt);
        print("BEGIN ");
        printIf("DEFERRED ", stmt.type == BeginStmt.Type.DEFERRED);
        printIf("IMMEDIATE ", stmt.type == BeginStmt.Type.IMMEDIATE);
        printIf("EXCLUSIVE ", stmt.type == BeginStmt.Type.EXCLUSIVE);
        printIf("TRANSACTION", stmt.hasTransaction);
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
        visit((SqlStatement) stmt);
        print("SAVEPOINT ");
    }

    @Override
    public void visit(VacuumStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    private void visit(AlterTableStmt stmt) {
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

    private void visit(CreateStmt stmt) {
        visit((SqlStatement) stmt);
        print("CREATE ");
    }

    private void visit(CreateTableStmt stmt) {
        visit((CreateStmt) stmt);
        printIf("TEMP ", stmt.hasTemporary);
        print("TABLE ");
        printIf("IF NOT EXISTS ", stmt.hasIfNotExists);
        printNode(stmt.database, ".", false);
        printNode(stmt.name);
    }

    @Override
    public void visit(CreateTableStmtWithColumns stmt) {
        visit((CreateTableStmt) stmt);
        indent("(");
        printlnList(stmt.columns, stmt.constraints);
        unindent(")");
    }

    @Override
    public void visit(CreateTableStmtWithSelect stmt) {
        visit((CreateTableStmt) stmt);
        print("AS ");
        printNode(stmt.select);
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

    private void visit(DropStmt stmt) {
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

    private void visit(EventStmt stmt) {
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

    private void visit(InsertStmt stmt) {
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
        visit((SqlStatement) stmt);
        printNode(stmt.unit);
    }

    private void visit(SelectUnit unit) {
    }

    @Override
    public void visit(SelectCore core) {
        print("SELECT ");
        printIf("DISTINCT ", core.hasDistinct);
        // TODO: finish
    }

    @Override
    public void visit(SelectCompound compound) {
        // TODO Auto-generated method stub
        
    }

    private void visit(ResultColumn column) {
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

    private void visit(JoinConstraint constraint) {
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

    private void visit(JoinSrc src) {
        // TODO Auto-generated method stub
        
    }

    private void visit(SingleSrc src) {
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
    public void visit(ColumnAssignment assign) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(PragmaStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    private void visit(PragmaValue value) {
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

    private void visit(Constraint constraint) {
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

    private void visit(ForeignKeySetting sett) {
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

    private void visit(ColumnConstraint constraint) {
        printNode(constraint.name, "CONSTRAINT ", true);
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
        visit((ColumnConstraint) constraint);
        print("PRIMARY KEY ");
        printIf("ASC ", constraint.order == Order.ASC);
        printIf("DESC ", constraint.order == Order.DESC);
        printNode(constraint.clause);
        printIf("AUTOINCREMENT ", constraint.hasAutoincrement);
    }

    @Override
    public void visit(UniqueColumnConstraint constraint) {
        // TODO Auto-generated method stub
        
    }

    private void visit(TableConstraint constraint) {
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

    private void visit(Expression expr) {
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

    private void visit(InExpr expr) {
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
    
    private int mPad = 0;
    
    private boolean mIndent;
    
    private void print(String str) {
        if (mIndent) {
            for (int i = 0; i < mPad; i++) {
                mStream.print("  ");
            }
            mIndent = false;
        }
        mStream.print(str);
    }

    private void println() {
        mStream.println();
        mIndent = true;
    }

    private void println(String str) {
        print(str);
        println();
    }
    
    private void indent() {
        mPad++;
    }
    
    private void indent(String str) {
        println(str);
        indent();
    }
    
    private void unindent() {
        mPad--;
    }

    private void unindent(String str) {
        println();
        unindent();
        print(str);
    }
    
    private void printIf(String str, boolean condition) {
        if (condition) {
            mStream.print(str);
        }
    }

    private void printNode(Node node) {
        if (node != null) {
            node.accept(this);
        }
    }
    
    private void printNode(Node node, String str, boolean reverse) {
        if (node != null) {
            if (reverse) {
                mStream.print(str);
                node.accept(this);
                return;
            }
            node.accept(this);
            mStream.print(str);
        }
    }
    
    private void printList(List<? extends Node> nodes) {
        if (nodes != null) {
            for (Node node : nodes) {
                printNode(node);
            }
        }
    }
    
    private void printlnList(List<? extends Node> nodes) {
        if (nodes != null) {
            for (Node node : nodes) {
                printNode(node);
                println();
            }
        }
    }
    
    private void printlnList(List<? extends Node> first, List<? extends Node> second) {
        if (first != null) {
            Iterator<? extends Node> it = first.iterator();
            if (it.hasNext()) {
                printNode(it.next());
            }
            while (it.hasNext()) {
                println(",");
                printNode(it.next());
            }
        }
        if (second != null) {
            for (Node node : second) {
                println(",");
                printNode(node);
            }
        }
    }

}