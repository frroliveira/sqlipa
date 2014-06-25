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
        printList(column.constraints, "");
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
        printList(stmtList.stmts, ";");
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
        visit((SqlStatement) stmt);
    	printIf("COMMIT ", stmt.type == CommitStmt.Type.COMMIT);
    	printIf("END ", stmt.type == CommitStmt.Type.END);
    	printIf("TRANSACTION ", stmt.hasTransaction);
    }

    @Override
    public void visit(DetachStmt stmt) {
        visit((SqlStatement) stmt);
    	print("DETACH ");
    	printIf("DATABASE ", stmt.hasDatabase);
    	printNode(stmt.database);
    }

    @Override
    public void visit(ReindexStmt stmt) {
        visit((SqlStatement) stmt);
    	print("REINDEX ");
        printNode(stmt.first);
        printNode(stmt.second, ".", true);
    }

    @Override
    public void visit(ReleaseStmt stmt) {
        visit((SqlStatement) stmt);
    	print("RELEASE ");
    	printIf("SAVEPOINT ", stmt.hasSavepoint);
    	printNode(stmt.savepoint);
	}

    @Override
    public void visit(RollbackStmt stmt) {
        visit((SqlStatement) stmt);
        print("ROLLBACK ");
        printIf("TRANSACTION ", stmt.hasTransaction);
        printIf("TO ", stmt.savepoint != null);
        printIf("SAVEPOINT ", stmt.hasSavepoint);
        printNode(stmt.savepoint);
    }

    @Override
    public void visit(SavepointStmt stmt) {
        visit((SqlStatement) stmt);
        print("SAVEPOINT ");
        printNode(stmt.savepoint);
    }

    @Override
    public void visit(VacuumStmt stmt) {
        visit((SqlStatement) stmt);
        print("VACUUM");        
    }

    private void visit(AlterTableStmt stmt) {
        visit((SqlStatement) stmt);
        print("ALTER TABLE ");
        printNode(stmt.database, ".", false);
        printNode(stmt.table);
    }

    @Override
    public void visit(AddColumnStmt stmt) {
        visit((AlterTableStmt) stmt);
        print("ADD ");
        printIf("COLUMN ", stmt.hasColumn);
        printNode(stmt.column);
    }

    @Override
    public void visit(RenameTableStmt stmt) {
        visit((AlterTableStmt) stmt);
        print("RENAME TO ");
        printNode(stmt.newTable);
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
        printlnList(stmt.columns, stmt.constraints, ",");
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
        visit((CreateStmt) stmt);
        printIf("UNIQUE ", stmt.hasUnique);
        print("INDEX ");
        printIf("IF NOT EXISTS ", stmt.hasIfNotExists);
        printNode(stmt.database, ".", false);
        printNode(stmt.name);
        print("ON ");
        printNode(stmt.table);
        indent("(");
        printlnList(stmt.columns, ",");
        unindent(")");
    }

    @Override
    public void visit(CreateViewStmt stmt) {
        visit((CreateStmt) stmt);
        printIf("TEMP ", stmt.hasTemporary);
        print("VIEW ");
        printIf("IF NOT EXISTS ", stmt.hasIfNotExists);
        printNode(stmt.database, ".", false);
        printNode(stmt.name);
        print("AS ");
        printNode(stmt.select);
    }

    @Override
    public void visit(CreateTriggerStmt stmt) {
        visit((CreateStmt) stmt);
        printIf("TEMP ", stmt.hasTemporary);
        print("TRIGGER ");
        printIf("IF NOT EXISTS ", stmt.hasIfNotExists);
        printNode(stmt.database, ".", false);
        printNode(stmt.name);
        
        printIf("BEFORE ", stmt.time == CreateTriggerStmt.Time.BEFORE);
        printIf("AFTER ", stmt.time == CreateTriggerStmt.Time.AFTER);
        printIf("INSTEAD OF ", stmt.time == CreateTriggerStmt.Time.INSTEAD_OF);
        
        printIf("DELETE ", stmt.event == CreateTriggerStmt.Event.DELETE);
        printIf("INSERT ", stmt.event == CreateTriggerStmt.Event.INSERT);
        printIf("UPDATE ", stmt.event == CreateTriggerStmt.Event.UPDATE);
        
        printIf("OF ", stmt.columns.size() > 0);
        printList(stmt.columns, ",");
        
        print("ON ");
        printNode(stmt.table);
        printIf("FOR EACH ROW ", stmt.hasForEachRow);
        printNode(stmt.when);
        
        print("BEGIN ");
        printList(stmt.stmts, ";");
        print("END");
    }

    @Override
    public void visit(CreateVirtualTableStmt stmt) {
        visit((CreateStmt) stmt);
        print("VIRTUAL TABLE ");
        printIf("IF NOT EXISTS ", stmt.hasIfNotExists);
        printNode(stmt.database, ".", false);
        printNode(stmt.name);
        print("USING ");
        printNode(stmt.module);
        printIf("(", stmt.arguments.size() > 0);
        printList(stmt.arguments, ",");
        printIf(")", stmt.arguments.size() > 0);
    }

    private void visit(DropStmt stmt, String type) {
        visit((SqlStatement) stmt);
        print("DROP " + type);
        printIf("IF EXISTS ", stmt.hasIfExists);
        printNode(stmt.database, ".", false);
        printNode(stmt.name);
    }

    @Override
    public void visit(DropIndexStmt stmt) {
        visit((DropStmt) stmt, "INDEX ");
    }

    @Override
    public void visit(DropTableStmt stmt) {
        visit((DropStmt) stmt, "TABLE ");
    }

    @Override
    public void visit(DropTriggerStmt stmt) {
        visit((DropStmt) stmt, "TRIGGER ");
    }

    @Override
    public void visit(DropViewStmt stmt) {
        visit((DropStmt) stmt, "VIEW ");
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
        visit((SqlStatement) stmt);
        print("DELETE FROM ");
        printNode(stmt.qualifiedTable);
        printIf("WHERE ", stmt.where != null);
        printNode(stmt.where);
        printNode(stmt.constraint);
    }

    private void visit(InsertStmt stmt) {
        visit((SqlStatement) stmt);
        printIf("INSERT ", stmt.type == InsertStmt.Type.INSERT);
        printIf("INSERT OR ROLLBACK ", stmt.type == InsertStmt.Type.INSERT_OR_ROLLBACK);
        printIf("INSERT OR ABORT ", stmt.type == InsertStmt.Type.INSERT_OR_ABORT);
        printIf("INSERT OR REPLACE ", stmt.type == InsertStmt.Type.INSERT_OR_REPLACE);
        printIf("INSERT OR FAIL ", stmt.type == InsertStmt.Type.INSERT_OR_FAIL);
        printIf("INSERT OR IGNORE ", stmt.type == InsertStmt.Type.INSERT_OR_IGNORE);
        printIf("REPLACE ", stmt.type == InsertStmt.Type.REPLACE);
        
        print("INTO ");
        printNode(stmt.database, ".", false);
        printNode(stmt.table);
    }

    @Override
    public void visit(InsertStmtDefault stmt) {
        visit((InsertStmt) stmt);
        print("DEFAULT VALUES");
    }

    @Override
    public void visit(InsertStmtWithSelect stmt) {
        visit((InsertStmt) stmt);
        printIf("(", stmt.columns.size() > 0);
        printList(stmt.columns, ",");
        printIf(")", stmt.columns.size() > 0);
        printNode(stmt.select);        
    }

    @Override
    public void visit(InsertStmtWithValues stmt) {
        visit((InsertStmt) stmt);
        printIf("(", stmt.columns.size() > 0);
        printList(stmt.columns, ",");
        printIf(")", stmt.columns.size() > 0);
        print("VALUES");
        
        Iterator<List<Expression>> it = stmt.rows.iterator();
        if (it.hasNext()) {
            printList(it.next(), ",", true);
        }
        while (it.hasNext()) {
            println(",");
            printList(it.next(), ",", true);
        }    
    }

    @Override
    public void visit(SelectStmt stmt) {
        visit((SqlStatement) stmt);
        printNode(stmt.unit);
        printNode(stmt.constraint);
    }

    @Override
    public void visit(SelectCore core) {
        print("SELECT ");
        printIf("DISTINCT ", core.hasDistinct);
        printIf("ALL ", core.hasAll);
        printList(core.columns, ",");
        printIf("FROM ", core.from != null);
        printNode(core.from);
        printIf("WHERE ", core.where != null);
        printNode(core.where);
        printIf("GROUP BY ", core.groupBy.size() > 0);
        printList(core.groupBy, ",");
        printIf("HAVING ", core.having != null);
        printNode(core.having);
    }

    @Override
    public void visit(SelectCompound compound) {
    	printNode(compound.left);
    	printIf("UNION ", compound.operator == SelectCompound.Operator.UNION);
    	printIf("UNION ALL ", compound.operator == SelectCompound.Operator.UNION_ALL);
    	printIf("INTERSECT ", compound.operator == SelectCompound.Operator.INTERSECT);
    	printIf("EXCEPT ", compound.operator == SelectCompound.Operator.EXCEPT);
    	printNode(compound.right);
    }
    
    @Override
    public void visit(ExpressionColumn column) {
    	printNode(column.expr);        
    }

    @Override
    public void visit(AliasedColumn column) {
    	visit((ExpressionColumn) column);
    	printIf("AS ", column.hasAs);
    	printNode(column.alias);
    }

    @Override
    public void visit(UniversalColumn column) {
    	printNode(column.table, ".", false);
    	print("*");
    }

    @Override
    public void visit(JoinConstraintOn constraint) {
    	print("ON ");
    	printNode(constraint.expr);
    }

    @Override
    public void visit(JoinConstraintUsing constraint) {
    	print("USING ");
    	printList(constraint.columns, ",", true);
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
        visit((SqlStatement) stmt);
        print("UPDATE ");
        printIf("OR ROLLBACK ", stmt.type == UpdateStmt.Type.UPDATE_OR_ROLLBACK);
        printIf("OR ABORT ", stmt.type == UpdateStmt.Type.UPDATE_OR_ABORT);
        printIf("OR REPLACE ", stmt.type == UpdateStmt.Type.UPDATE_OR_REPLACE);
        printIf("OR FAIL ", stmt.type == UpdateStmt.Type.UPDATE_OR_FAIL);
        printIf("OR IGNORE ", stmt.type == UpdateStmt.Type.UPDATE_OR_IGNORE);
        printNode(stmt.qualifiedTable);
        print("SET ");
        printList(stmt.assignments, ",");
        printIf("WHERE ", stmt.where != null);
        printNode(stmt.where);
    }

    @Override
    public void visit(ColumnAssignment assignment) {
    	printNode(assignment.column);
    	print("= ");
    	printNode(assignment.expr);
    }

    @Override
    public void visit(PragmaStmt stmt) {
        visit((SqlStatement) stmt);
    	print("PRAGMA ");
        printNode(stmt.database, ".", false);
        printNode(stmt.pragma);
        print("= "); // TODO: parentheses case.
        printNode(stmt.value);
    }

    @Override
    public void visit(PragmaNumber number) {
    	printNode(number.number);
    }

    @Override
    public void visit(PragmaName name) {
    	printNode(name.name);
    }

    @Override
    public void visit(PragmaString string) {
    	printNode(string.string);
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
    	visit((ColumnConstraint) constraint);
    	print("CHECK( ");
    	printNode(constraint.expr);
    	print(")");
    }

    @Override
    public void visit(CollateColumnConstraint constraint) {
    	visit((ColumnConstraint) constraint);
    	print("COLLATE ");
    	printNode(constraint.collation);
    }

    @Override
    public void visit(DefaultColumnConstraint constraint) {
    	visit((ColumnConstraint) constraint);
    	print("DEFAULT ");
    	printNode(constraint.expr); // TODO: see possible parentheses.
    }

    @Override
    public void visit(ForeignKeyColumnConstraint constraint) {
    	visit((ColumnConstraint) constraint);
		printNode(constraint.clause);
    }

    @Override
    public void visit(NotNullColumnConstraint constraint) {
    	visit((ColumnConstraint) constraint);
    	print("NOT NULL ");
    	printNode(constraint.clause);
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
    	visit((ColumnConstraint) constraint);
    	print("UNIQUE ");
    	printNode(constraint.clause);
    }

    private void visit(TableConstraint constraint) {
        printNode(constraint.name, "CONSTRAINT ", true);        
    }

    @Override
    public void visit(CheckTableConstraint constraint) {
    	visit((TableConstraint) constraint);
    	print("CHECK( ");
    	printNode(constraint.expr);
    	print(")");
    }

    @Override
    public void visit(ForeignKeyTableConstraint constraint) {
    	visit((TableConstraint) constraint);
    	print("FOREIGN KEY ");
    	printList(constraint.columns, ",", true);
		printNode(constraint.clause);
    }

    @Override
    public void visit(PrimaryKeyTableConstraint constraint) {
    	visit((TableConstraint) constraint);
        print("PRIMARY KEY ");
        printList(constraint.columns, ",", true);
        printNode(constraint.clause);
    }

    @Override
    public void visit(UniqueTableConstraint constraint) {
    	visit((TableConstraint) constraint);
        print("UNIQUE ");
        printList(constraint.columns, ",", true);
        printNode(constraint.clause);        
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

    private void printList(List<? extends Node> nodes, String separator) {
    	printList(nodes, separator, false);
    }
    
    private void printList(List<? extends Node> nodes, String separator,
    		boolean withParentheses) {
        if (nodes != null) {
            Iterator<? extends Node> it = nodes.iterator();
            if (withParentheses) {
            	print("(");
            }
            if (it.hasNext()) {
                printNode(it.next());
            }
            while (it.hasNext()) {
                print(separator);
                printNode(it.next());
            }
            if (withParentheses) {
            	print(")");
            }
        }
    }
    
    private void printlnList(List<? extends Node> nodes, String separator) {
        if (nodes != null) {
            Iterator<? extends Node> it = nodes.iterator();
            if (it.hasNext()) {
                printNode(it.next());
            }
            while (it.hasNext()) {
                println(separator);
                printNode(it.next());
            }
        }
    }
    
    private void printlnList(List<? extends Node> first, List<? extends Node> second,
    		String separator) {
        if (first != null) {
            Iterator<? extends Node> it = first.iterator();
            if (it.hasNext()) {
                printNode(it.next());
            }
            while (it.hasNext()) {
                println(separator);
                printNode(it.next());
            }
        }
        if (second != null) {
            for (Node node : second) {
                println(separator);
                printNode(node);
            }
        }
    }

}