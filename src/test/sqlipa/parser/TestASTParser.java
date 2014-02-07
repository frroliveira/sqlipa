package test.sqlipa.parser;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import main.sqlipa.ast.Node;
import main.sqlipa.ast.stmt.AnalyzeStmt;
import main.sqlipa.ast.stmt.AttachStmt;
import main.sqlipa.ast.stmt.BeginStmt;
import main.sqlipa.ast.stmt.alter.AddColumnStmt;
import main.sqlipa.ast.stmt.alter.AlterTableStmt;
import main.sqlipa.ast.stmt.alter.RenameTableStmt;
import main.sqlipa.ast.stmt.create.CreateIndexStmt;
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
        AlterTableStmt alter = stmt("ALTER TABLE table_name RENAME TO new_table_name")
                .alterTableStmt();  
        
        assertTrue(alter instanceof RenameTableStmt);
        assertNull(alter.database);
        assertEquals("table_name", alter.table.name);
        assertEquals("new_table_name", ((RenameTableStmt) alter).newTable.name);

        // With database specification.
        alter = stmt("ALTER TABLE database_name.table_name RENAME TO new_table_name")
                .alterTableStmt();

        assertTrue(alter instanceof RenameTableStmt);
        assertEquals("database_name", alter.database.name);
        assertEquals("table_name", alter.table.name);
        assertEquals("new_table_name", ((RenameTableStmt) alter).newTable.name);
    }

    @Test
    public void testAlterTableStmt_addColumn() throws ParseException {
        // Without database specification and with COLUMN.
        AlterTableStmt stmt = stmt("ALTER TABLE table_name ADD COLUMN new_column INTEGER NOT NULL")
                .alterTableStmt();
        
        assertTrue(stmt instanceof AddColumnStmt);
        assertNull(stmt.database);
        assertEquals("table_name", stmt.table.name);
        assertNotNull(((AddColumnStmt) stmt).column);
        
        // With database specification and without COLUMN.
        stmt = stmt("ALTER TABLE database_name.table_name ADD new_column INTEGER NOT NULL")
                .alterTableStmt();
        
        assertTrue(stmt instanceof AddColumnStmt);
        assertEquals("database_name", stmt.database.name);
        assertEquals("table_name", stmt.table.name);
        assertNotNull(((AddColumnStmt) stmt).column);
    }
    
    @Test
    public void testAnalyzeStmt() throws ParseException {
        // One name in ANALYZE.
        AnalyzeStmt stmt = stmt("ANALYZE table_name").analyzeStmt();
        
        assertEquals("table_name", stmt.first.name);
        assertNull(stmt.second);
     
        // Two names in ANALYZE.
        stmt = stmt("ANALYZE database_name.index_name").analyzeStmt();
        
        assertEquals("database_name", stmt.first.name);
        assertEquals("index_name", stmt.second.name);        
    }

    @Test
    public void testAttachStmt() throws ParseException {
        // Without DATABASE.
        AttachStmt stmt = stmt("ATTACH file_name AS database_name").attachStmt();
        
        assertNotNull(stmt.expr);
        assertEquals("database_name", stmt.database.name);
     
        // With DATABASE.
        stmt = stmt("ATTACH DATABASE file_name AS database_name").attachStmt();
        
        assertNotNull(stmt.expr);
        assertEquals("database_name", stmt.database.name);
    }

    @Test
    public void testBeginStmt() throws ParseException {
        assertNull(stmt("BEGIN").beginStmt().type);
        assertNull(stmt("BEGIN TRANSACTION").beginStmt().type);
        assertEquals(BeginStmt.Type.DEFERRED, stmt("BEGIN DEFERRED").beginStmt().type);
        assertEquals(BeginStmt.Type.IMMEDIATE, stmt("BEGIN IMMEDIATE").beginStmt().type);
        assertEquals(BeginStmt.Type.EXCLUSIVE, stmt("BEGIN EXCLUSIVE TRANSACTION").beginStmt().type);
    }

    @Test
    public void testCommitStmt() throws ParseException {
        assertNotNull(stmt("END").commitStmt());
        assertNotNull(stmt("COMMIT").commitStmt());
        assertNotNull(stmt("END TRANSACTION").commitStmt());
        assertNotNull(stmt("COMMIT TRANSACTION").commitStmt());
    }
    
    @Test
    public void testRollbackStmt() throws ParseException {
        assertNull(stmt("ROLLBACK").rollbackStmt().savepoint);
        assertNull(stmt("ROLLBACK TRANSACTION").rollbackStmt().savepoint);
        assertEquals("savepoint_name", stmt("ROLLBACK TO savepoint_name").rollbackStmt().savepoint.name);
        assertEquals("savepoint_name", stmt("ROLLBACK TO SAVEPOINT savepoint_name").rollbackStmt().savepoint.name);
        assertEquals("savepoint_name", stmt("ROLLBACK TRANSACTION TO savepoint_name").rollbackStmt().savepoint.name);
        assertEquals("savepoint_name", stmt("ROLLBACK TRANSACTION TO SAVEPOINT savepoint_name").rollbackStmt().savepoint.name);    
    }

    @Test
    public void testSavepointStmt() throws ParseException {
        assertEquals("savepoint_name", stmt("SAVEPOINT savepoint_name").savepointStmt().savepoint.name);
    }
    
    @Test
    public void testReleaseStmt() throws ParseException {
        assertEquals("savepoint_name", stmt("RELEASE savepoint_name").releaseStmt().savepoint.name);        
        assertEquals("savepoint_name", stmt("RELEASE SAVEPOINT savepoint_name").releaseStmt().savepoint.name);        
    }
    
    @Test
    public void testCreateIndexStmt() throws ParseException {
        CreateIndexStmt stmt = stmt("CREATE INDEX IF NOT EXISTS index_name ON table_name(column_name1)").createIndexStmt();
        
        assertFalse(stmt.hasUnique);
        assertTrue(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("index_name", stmt.name.name);
        assertEquals("table_name", stmt.table.name);
        assertList(stmt.columns, 1);

        stmt = stmt("CREATE UNIQUE INDEX database_name.index_name ON table_name(column_name1, column2)").createIndexStmt();
        
        assertTrue(stmt.hasUnique);
        assertFalse(stmt.hasIfNotExists);
        assertEquals("database_name", stmt.database.name);
        assertEquals("index_name", stmt.name.name);
        assertEquals("table_name", stmt.table.name);
        assertList(stmt.columns, 2);
        
        thrown.expect(ParseException.class);
        stmt = stmt("CREATE INDEX index_name ON table_name()").createIndexStmt();
    }
    
    @Test
    public void testIndexedColumn() throws ParseException {
        // TODO:
    }

    @Test
    public void testCreateTableStmt() throws ParseException {
        // TODO:
    }

    @Test
    public void testColumnDef() throws ParseException {
        // TODO:
    }
    
    @Test
    public void testTypeName() throws ParseException {
        // TODO:
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
        // TODO:
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
    
    private List<String> stmts = new ArrayList<String>();

    private ASTParser parser(final String sql) {
        return new ASTParser(new StringReader(sql));
    }
    
    private ASTParser stmt(final String sql) {
        stmts.add(sql);
        return parser(sql);
    }
    
    private void assertList(List<? extends Node> nodes, int size) {
        assertTrue(nodes.size() == size);
        for (Node node : nodes) {
            assertNotNull(node);
        }
    }

}