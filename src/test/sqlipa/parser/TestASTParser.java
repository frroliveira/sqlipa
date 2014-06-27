package test.sqlipa.parser;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import main.sqlipa.ast.ColumnDef;
import main.sqlipa.ast.IndexedColumn;
import main.sqlipa.ast.Node;
import main.sqlipa.ast.TypeName;
import main.sqlipa.ast.stmt.AnalyzeStmt;
import main.sqlipa.ast.stmt.AttachStmt;
import main.sqlipa.ast.stmt.BeginStmt;
import main.sqlipa.ast.stmt.alter.AddColumnStmt;
import main.sqlipa.ast.stmt.alter.AlterTableStmt;
import main.sqlipa.ast.stmt.alter.RenameTableStmt;
import main.sqlipa.ast.stmt.create.CreateIndexStmt;
import main.sqlipa.ast.stmt.create.CreateTableStmt;
import main.sqlipa.ast.stmt.create.CreateTableStmtWithColumns;
import main.sqlipa.ast.stmt.create.CreateTableStmtWithSelect;
import main.sqlipa.ast.stmt.create.CreateTriggerStmt;
import main.sqlipa.ast.stmt.event.delete.DeleteStmt;
import main.sqlipa.ast.stmt.event.insert.InsertStmt;
import main.sqlipa.ast.stmt.event.select.SelectStmt;
import main.sqlipa.ast.stmt.event.update.UpdateStmt;
import main.sqlipa.parser.ASTParser;
import main.sqlipa.parser.ParseException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestASTParser {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAlterTableStmt_rename() throws ParseException {
        // Without database specification.
        // -- ALTER TABLE table_name RENAME TO new_table_name
        AlterTableStmt stmt = stmt("alter1").alterTableStmt();

        assertTrue(stmt instanceof RenameTableStmt);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.table.name);
        assertEquals("new_table_name", ((RenameTableStmt) stmt).newTable.name);

        // With database specification.
        // -- ALTER TABLE database_name.table_name RENAME TO new_table_name
        stmt = stmt("alter2").alterTableStmt();

        assertTrue(stmt instanceof RenameTableStmt);
        assertEquals("database_name", stmt.database.name);
        assertEquals("table_name", stmt.table.name);
        assertEquals("new_table_name", ((RenameTableStmt) stmt).newTable.name);
    }

    @Test
    public void testAlterTableStmt_addColumn() throws ParseException {
        // Without database specification and with COLUMN.
        // -- ALTER TABLE table_name ADD COLUMN new_column INTEGER NOT NULL
        AlterTableStmt stmt = stmt("alter3").alterTableStmt();

        assertTrue(stmt instanceof AddColumnStmt);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.table.name);
        assertNotNull(((AddColumnStmt) stmt).column);

        // With database specification and without COLUMN.
        // -- ALTER TABLE database_name.table_name ADD new_column INTEGER NOT
        // NULL
        stmt = stmt("alter4").alterTableStmt();

        assertTrue(stmt instanceof AddColumnStmt);
        assertEquals("database_name", stmt.database.name);
        assertEquals("table_name", stmt.table.name);
        assertNotNull(((AddColumnStmt) stmt).column);
    }

    @Test
    public void testAnalyzeStmt() throws ParseException {
        // One name in ANALYZE.
        // -- ANALYZE table_name
        AnalyzeStmt stmt = stmt("analyze1").analyzeStmt();

        assertEquals("table_name", stmt.first.name);
        assertNull(stmt.second);

        // Two names in ANALYZE.
        // -- ANALYZE database_name.index_name
        stmt = stmt("analyze2").analyzeStmt();

        assertEquals("database_name", stmt.first.name);
        assertEquals("index_name", stmt.second.name);
    }

    @Test
    public void testAttachStmt() throws ParseException {
        // Without DATABASE.
        // -- ATTACH file_name AS database_name
        AttachStmt stmt = stmt("attach1").attachStmt();

        assertNotNull(stmt.expr);
        assertEquals("database_name", stmt.database.name);

        // With DATABASE.
        // -- ATTACH DATABASE file_name AS database_name
        stmt = stmt("attach2").attachStmt();

        assertNotNull(stmt.expr);
        assertEquals("database_name", stmt.database.name);
    }

    @Test
    public void testBeginStmt() throws ParseException {
        // -- BEGIN
        assertNull(stmt("begin1").beginStmt().type);
        // -- BEGIN TRANSACTION
        assertNull(stmt("begin2").beginStmt().type);
        // -- BEGIN DEFERRED
        assertEquals(BeginStmt.Type.DEFERRED, stmt("begin3").beginStmt().type);
        // -- BEGIN IMMEDIATE
        assertEquals(BeginStmt.Type.IMMEDIATE, stmt("begin4").beginStmt().type);
        // -- BEGIN EXCLUSIVE TRANSACTION
        assertEquals(BeginStmt.Type.EXCLUSIVE, stmt("begin5").beginStmt().type);
    }

    @Test
    public void testCommitStmt() throws ParseException {
        // -- END
        assertNotNull(stmt("commit1").commitStmt());
        // -- COMMIT
        assertNotNull(stmt("commit2").commitStmt());
        // -- END TRANSACTION
        assertNotNull(stmt("commit3").commitStmt());
        // -- COMMIT TRANSACTION
        assertNotNull(stmt("commit4").commitStmt());
    }

    @Test
    public void testRollbackStmt() throws ParseException {
        // -- ROLLBACK
        assertNull(stmt("rollback1").rollbackStmt().savepoint);
        // -- ROLLBACK TRANSACTION
        assertNull(stmt("rollback2").rollbackStmt().savepoint);
        // -- ROLLBACK TO savepoint_name
        assertEquals("savepoint_name",
                stmt("rollback3").rollbackStmt().savepoint.name);
        // -- ROLLBACK TO SAVEPOINT savepoint_name
        assertEquals("savepoint_name",
                stmt("rollback4").rollbackStmt().savepoint.name);
        // -- ROLLBACK TRANSACTION TO savepoint_name
        assertEquals("savepoint_name",
                stmt("rollback5").rollbackStmt().savepoint.name);
        // -- ROLLBACK TRANSACTION TO SAVEPOINT savepoint_name
        assertEquals("savepoint_name",
                stmt("rollback6").rollbackStmt().savepoint.name);
    }

    @Test
    public void testSavepointStmt() throws ParseException {
        // -- SAVEPOINT savepoint_name
        assertEquals("savepoint_name",
                stmt("savepoint1").savepointStmt().savepoint.name);
    }

    @Test
    public void testReleaseStmt() throws ParseException {
        // -- RELEASE savepoint_name
        assertEquals("savepoint_name",
                stmt("release1").releaseStmt().savepoint.name);
        // -- RELEASE SAVEPOINT savepoint_name
        assertEquals("savepoint_name",
                stmt("release2").releaseStmt().savepoint.name);
    }

    @Test
    public void testCreateIndexStmt() throws ParseException {
        // -- CREATE INDEX IF NOT EXISTS index_name ON table_name(column_name1)
        CreateIndexStmt stmt = stmt("create_index1").createIndexStmt();

        assertFalse(stmt.hasUnique);
        assertTrue(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("index_name", stmt.name.name);
        assertEquals("table_name", stmt.table.name);
        assertList(stmt.columns, 1);

        // -- CREATE UNIQUE INDEX database_name.index_name ON
        // table_name(column_name1, column_name2)
        stmt = stmt("create_index2").createIndexStmt();

        assertTrue(stmt.hasUnique);
        assertFalse(stmt.hasIfNotExists);
        assertEquals("database_name", stmt.database.name);
        assertEquals("index_name", stmt.name.name);
        assertEquals("table_name", stmt.table.name);
        assertList(stmt.columns, 2);

        // -- CREATE INDEX index_name ON table_name(column_name)
        stmt = stmt("create_index3").createIndexStmt();

        assertFalse(stmt.hasUnique);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("index_name", stmt.name.name);
        assertEquals("table_name", stmt.table.name);
        assertList(stmt.columns, 1);

        // -- CREATE INDEX index_name ON table_name()
        thrown.expect(ParseException.class);
        stmt("create_index4").createIndexStmt();
    }

    @Test
    public void testIndexedColumn() throws ParseException {
        // -- column_name COLLATE collation_name ASC
        IndexedColumn part = part("indexed_column1").indexedColumn();

        assertEquals("column_name", part.column.name);
        assertEquals("collation_name", part.collation.name);
        assertEquals(IndexedColumn.Order.ASC, part.order);

        // -- column_name DESC
        part = part("indexed_column2").indexedColumn();

        assertEquals("column_name", part.column.name);
        assertNull(part.collation);
        assertEquals(IndexedColumn.Order.DESC, part.order);

        // -- column_name
        part = part("indexed_column3").indexedColumn();

        assertEquals("column_name", part.column.name);
        assertNull(part.collation);
        assertNull(part.order);
    }

    @Test
    public void testCreateTableStmt_columns() throws ParseException {
        // -- CREATE TABLE IF NOT EXISTS table_name(
        // -- column_name1
        // -- )
        CreateTableStmt stmt = stmt("create_table1").createTableStmt();

        assertTrue(stmt instanceof CreateTableStmtWithColumns);
        assertFalse(stmt.hasTemporary);
        assertTrue(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.name.name);
        assertList(((CreateTableStmtWithColumns) stmt).columns, 1);
        assertNull(((CreateTableStmtWithColumns) stmt).constraints);

        // -- CREATE TEMP TABLE database_name.table_name(
        // -- column_name1,
        // -- column_name2
        // -- )
        stmt = stmt("create_table2").createTableStmt();

        assertTrue(stmt instanceof CreateTableStmtWithColumns);
        assertTrue(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertEquals("database_name", stmt.database.name);
        assertEquals("table_name", stmt.name.name);
        assertList(((CreateTableStmtWithColumns) stmt).columns, 2);
        assertNull(((CreateTableStmtWithColumns) stmt).constraints);

        // -- CREATE TEMPORARY TABLE table_name(
        // -- column_name1,
        // -- column_name2,
        // -- CHECK(column_name1 == 1)
        // -- )
        stmt = stmt("create_table3").createTableStmt();

        assertTrue(stmt instanceof CreateTableStmtWithColumns);
        assertTrue(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.name.name);
        assertList(((CreateTableStmtWithColumns) stmt).columns, 2);
        assertList(((CreateTableStmtWithColumns) stmt).constraints, 1);

        // -- CREATE TABLE table_name(
        // -- column_name1,
        // -- column_name2,
        // -- CHECK(column_name1 == 1),
        // -- CHECK(column_name2 == 2)
        // -- )
        stmt = stmt("create_table4").createTableStmt();

        assertTrue(stmt instanceof CreateTableStmtWithColumns);
        assertFalse(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.name.name);
        assertList(((CreateTableStmtWithColumns) stmt).columns, 2);
        assertList(((CreateTableStmtWithColumns) stmt).constraints, 2);

        // -- CREATE TABLE IF NOT EXISTS table_name()
        thrown.expect(ParseException.class);
        stmt("create_table5").createTableStmt();
    }

    @Test
    public void testCreateTableStmt_select() throws ParseException {
        // -- CREATE TABLE IF NOT EXISTS table_name AS SELECT *
        CreateTableStmt stmt = stmt("create_table6").createTableStmt();

        assertTrue(stmt instanceof CreateTableStmtWithSelect);
        assertFalse(stmt.hasTemporary);
        assertTrue(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.name.name);
        assertNotNull(((CreateTableStmtWithSelect) stmt).select);

        // -- CREATE TEMP TABLE database_name.table_name AS SELECT *
        stmt = stmt("create_table7").createTableStmt();

        assertTrue(stmt instanceof CreateTableStmtWithSelect);
        assertTrue(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertEquals("database_name", stmt.database.name);
        assertEquals("table_name", stmt.name.name);
        assertNotNull(((CreateTableStmtWithSelect) stmt).select);

        // -- CREATE TEMPORARY TABLE table_name AS SELECT *
        stmt = stmt("create_table8").createTableStmt();

        assertTrue(stmt instanceof CreateTableStmtWithSelect);
        assertTrue(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.name.name);
        assertNotNull(((CreateTableStmtWithSelect) stmt).select);
    }

    @Test
    public void testColumnDef() throws ParseException {
        // -- column_name
        ColumnDef part = part("column_def1").columnDef();

        assertEquals("column_name", part.column.name);
        assertNull(part.type);
        assertNull(part.constraints);

        // -- column_name type_name
        part = part("column_def2").columnDef();

        assertEquals("column_name", part.column.name);
        assertNotNull(part.type);
        assertNull(part.constraints);

        // -- column_name type_name NOT NULL
        part = part("column_def3").columnDef();

        assertEquals("column_name", part.column.name);
        assertNotNull(part.type);
        assertList(part.constraints, 1);

        // -- column_name type_name NOT NULL COLLATE collation_name
        part = part("column_def4").columnDef();

        assertEquals("column_name", part.column.name);
        assertNotNull(part.type);
        assertList(part.constraints, 2);

        // -- column_name NOT NULL
        part = part("column_def5").columnDef();

        assertEquals("column_name", part.column.name);
        assertNull(part.type);
        assertList(part.constraints, 1);

        // -- column_name type_name NOT NULL COLLATE collation_name
        part = part("column_def6").columnDef();

        assertEquals("column_name", part.column.name);
        assertNull(part.type);
        assertList(part.constraints, 2);
    }

    @Test
    public void testTypeName() throws ParseException {
        // -- name
        TypeName part = part("type_name1").typeName();

        assertEquals("name", part.name);
        assertNull(part.xDimension);
        assertNull(part.yDimension);

        // -- name(1)
        part = part("type_name2").typeName();

        assertEquals("name", part.name);
        assertNotNull(part.xDimension);
        assertNull(part.yDimension);

        // -- name(1,2)
        part = part("type_name3").typeName();

        assertEquals("name", part.name);
        assertNotNull(part.xDimension);
        assertNotNull(part.yDimension);

        // -- name1 name2 name3
        part = part("type_name4").typeName();

        assertEquals("name1 name2 name3", part.name);
        assertNull(part.xDimension);
        assertNull(part.yDimension);

        // -- name1 name2 name3(1)
        part = part("type_name5").typeName();

        assertEquals("name1 name2 name3", part.name);
        assertNotNull(part.xDimension);
        assertNull(part.yDimension);

        // -- name1 name2 name3(1,2)
        part = part("type_name6").typeName();

        assertEquals("name1 name2 name3", part.name);
        assertNotNull(part.xDimension);
        assertNotNull(part.yDimension);
    }

    @Test
    public void testColumnConstraint() throws ParseException {
        // TODO:
    }

    @Test
    public void testSignedNumber() throws ParseException {
        // TODO:
    }

    @Test
    public void testTableConstraint() throws ParseException {
        // TODO:
    }

    @Test
    public void testForeignKeyClause() throws ParseException {
        // TODO:
    }

    @Test
    public void testConflictClause() throws ParseException {
        // TODO:
    }

    @Test
    public void testCreateTriggerStmt() throws ParseException {
        // -- CREATE TRIGGER IF NOT EXISTS trigger_name BEFORE DELETE
        // -- ON table_name FOR EACH ROW
        // -- BEGIN
        // -- UPDATE table_name SET column_name = 1;
        // -- END;
        CreateTriggerStmt stmt = stmt("create_trigger1").createTriggerStmt();

        assertFalse(stmt.hasTemporary);
        assertTrue(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("trigger_name", stmt.name.name);
        assertEquals(CreateTriggerStmt.Time.BEFORE, stmt.time);
        assertEquals(CreateTriggerStmt.Event.DELETE, stmt.event);
        assertNull(stmt.columns);
        assertEquals("table_name", stmt.table.name);
        assertTrue(stmt.hasForEachRow);
        assertNull(stmt.when);
        assertList(stmt.stmts, 1);
        assertTrue(stmt.stmts.get(0) instanceof UpdateStmt);

        // -- CREATE TEMP TRIGGER database_name.trigger_name AFTER INSERT
        // -- ON table_name FOR EACH ROW WHEN column_name == 1
        // -- BEGIN
        // -- INSERT INTO table_name DEFAULT VALUES;
        // -- END;
        stmt = stmt("create_trigger2").createTriggerStmt();

        assertTrue(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertEquals("database_name", stmt.database.name);
        assertEquals("trigger_name", stmt.name.name);
        assertEquals(CreateTriggerStmt.Time.AFTER, stmt.time);
        assertEquals(CreateTriggerStmt.Event.INSERT, stmt.event);
        assertNull(stmt.columns);
        assertEquals("table_name", stmt.table.name);
        assertTrue(stmt.hasForEachRow);
        assertNotNull(stmt.when);
        assertList(stmt.stmts, 1);
        assertTrue(stmt.stmts.get(0) instanceof InsertStmt);

        // -- CREATE TEMPORARY TRIGGER trigger_name INSTEAD OF UPDATE
        // -- ON table_name WHEN column_name == 1
        // -- BEGIN
        // -- DELETE FROM table_name;
        // -- END;
        stmt = stmt("create_trigger3").createTriggerStmt();

        assertTrue(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("trigger_name", stmt.name.name);
        assertEquals(CreateTriggerStmt.Time.INSTEAD_OF, stmt.time);
        assertEquals(CreateTriggerStmt.Event.UPDATE, stmt.event);
        assertNull(stmt.columns);
        assertEquals("table_name", stmt.table.name);
        assertFalse(stmt.hasForEachRow);
        assertNotNull(stmt.when);
        assertList(stmt.stmts, 1);
        assertTrue(stmt.stmts.get(0) instanceof DeleteStmt);

        // -- CREATE TEMPORARY TRIGGER trigger_name INSTEAD OF UPDATE
        // -- ON table_name WHEN column_name == 1
        // -- BEGIN
        // -- INSERT INTO table_name DEFAULT VALUES;
        // -- DELETE FROM table_name;
        // -- END;
        stmt = stmt("create_trigger4").createTriggerStmt();

        assertTrue(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("trigger_name", stmt.name.name);
        assertEquals(CreateTriggerStmt.Time.INSTEAD_OF, stmt.time);
        assertEquals(CreateTriggerStmt.Event.UPDATE, stmt.event);
        assertNull(stmt.columns);
        assertEquals("table_name", stmt.table.name);
        assertFalse(stmt.hasForEachRow);
        assertNotNull(stmt.when);
        assertList(stmt.stmts, 2);
        assertTrue(stmt.stmts.get(0) instanceof InsertStmt);
        assertTrue(stmt.stmts.get(1) instanceof DeleteStmt);

        // -- CREATE TEMPORARY TRIGGER trigger_name INSTEAD OF UPDATE
        // -- ON table_name WHEN column_name == 1
        // -- BEGIN
        // -- END;
        thrown.expect(ParseException.class);
        stmt("create_trigger5").createTriggerStmt();

        // -- CREATE TRIGGER trigger_name UPDATE OF column_name1
        // -- ON table_name
        // -- BEGIN
        // -- SELECT *;
        // -- END;
        stmt = stmt("create_trigger6").createTriggerStmt();

        assertFalse(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("trigger_name", stmt.name.name);
        assertNull(stmt.time);
        assertEquals(CreateTriggerStmt.Event.UPDATE, stmt.event);
        assertList(stmt.columns, 1);
        assertEquals("table_name", stmt.table.name);
        assertFalse(stmt.hasForEachRow);
        assertNull(stmt.when);
        assertList(stmt.stmts, 1);
        assertTrue(stmt.stmts.get(0) instanceof SelectStmt);

        // -- CREATE TRIGGER trigger_name UPDATE OF column_name1, column_name2
        // -- ON table_name
        // -- BEGIN
        // -- SELECT *;
        // -- END;
        stmt = stmt("create_trigger7").createTriggerStmt();

        assertFalse(stmt.hasTemporary);
        assertFalse(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("trigger_name", stmt.name.name);
        assertNull(stmt.time);
        assertEquals(CreateTriggerStmt.Event.UPDATE, stmt.event);
        assertList(stmt.columns, 2);
        assertEquals("table_name", stmt.table.name);
        assertFalse(stmt.hasForEachRow);
        assertNull(stmt.when);
        assertList(stmt.stmts, 1);
        assertTrue(stmt.stmts.get(0) instanceof SelectStmt);

        // -- CREATE TRIGGER trigger_name UPDATE OF
        // -- ON table_name
        // -- BEGIN
        // -- SELECT *;
        // -- END;
        thrown.expect(ParseException.class);
        stmt("create_trigger8").createTriggerStmt();
    }

    @Test
    public void testCreateViewStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testCreateVirtualTableStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testDeleteStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testEventConstraint() throws ParseException {
        // TODO:
    }

    @Test
    public void testDetachStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testDropIndexStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testDropTableStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testDropTriggerStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testDropViewStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testExpression() throws ParseException {
        // TODO:
    }

    @Test
    public void testLiteral() throws ParseException {
        // TODO:
    }

    @Test
    public void testInsertStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testPragmaStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testReindexStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testSelectStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testUpdateStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testQualifiedTableName() throws ParseException {
        // TODO:
    }

    @Test
    public void testVacuumStmt() throws ParseException {
        // TODO:
    }

    private TestHelper mHelper = new TestHelper();

    private ASTParser parser(final String sql) {
        return new ASTParser(new StringReader(sql));
    }

    private ASTParser stmt(final String part) {
        return parser(mHelper.getStmt(part));
    }

    private ASTParser part(final String part) {
        return parser(mHelper.getPart(part));
    }

    private void assertList(List<? extends Node> nodes, int size) {
        assertTrue(nodes.size() == size);
        for (Node node : nodes) {
            assertNotNull(node);
        }
    }

}