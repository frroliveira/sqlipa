package test.sqlipa.parser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
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
    	// -- ALTER TABLE table_name RENAME TO new_table_name
        AlterTableStmt alter = stmt("alter1").alterTableStmt();
        
        assertTrue(alter instanceof RenameTableStmt);
        assertNull(alter.database);
        assertEquals("table_name", alter.table.name);
        assertEquals("new_table_name", ((RenameTableStmt) alter).newTable.name);

        // With database specification.
        // -- ALTER TABLE database_name.table_name RENAME TO new_table_name
        alter = stmt("alter2").alterTableStmt();

        assertTrue(alter instanceof RenameTableStmt);
        assertEquals("database_name", alter.database.name);
        assertEquals("table_name", alter.table.name);
        assertEquals("new_table_name", ((RenameTableStmt) alter).newTable.name);
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
        // -- ALTER TABLE database_name.table_name ADD new_column INTEGER NOT NULL
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
        assertEquals("savepoint_name", stmt("rollback3").rollbackStmt().savepoint.name);
        // -- ROLLBACK TO SAVEPOINT savepoint_name
        assertEquals("savepoint_name", stmt("rollback4").rollbackStmt().savepoint.name);
        // -- ROLLBACK TRANSACTION TO savepoint_name
        assertEquals("savepoint_name", stmt("rollback5").rollbackStmt().savepoint.name);
        // -- ROLLBACK TRANSACTION TO SAVEPOINT savepoint_name
        assertEquals("savepoint_name", stmt("rollback6").rollbackStmt().savepoint.name);    
    }

    @Test
    public void testSavepointStmt() throws ParseException {
    	// -- SAVEPOINT savepoint_name
        assertEquals("savepoint_name", stmt("savepoint1").savepointStmt().savepoint.name);
    }
    
    @Test
    public void testReleaseStmt() throws ParseException {
    	// -- RELEASE savepoint_name
        assertEquals("savepoint_name", stmt("release1").releaseStmt().savepoint.name);
        // -- RELEASE SAVEPOINT savepoint_name
        assertEquals("savepoint_name", stmt("release2").releaseStmt().savepoint.name);        
    }
    
    @Test
    public void testCreateIndexStmt() throws ParseException {
    	// -- CREATE INDEX IF NOT EXISTS index_name ON table_name(column_name1)
        CreateIndexStmt stmt = stmt("index1").createIndexStmt();
        
        assertFalse(stmt.hasUnique);
        assertTrue(stmt.hasIfNotExists);
        assertNull(stmt.database);
        assertEquals("index_name", stmt.name.name);
        assertEquals("table_name", stmt.table.name);
        assertList(stmt.columns, 1);

        // -- CREATE UNIQUE INDEX database_name.index_name ON table_name(column_name1, column2)
        stmt = stmt("index2").createIndexStmt();
        
        assertTrue(stmt.hasUnique);
        assertFalse(stmt.hasIfNotExists);
        assertEquals("database_name", stmt.database.name);
        assertEquals("index_name", stmt.name.name);
        assertEquals("table_name", stmt.table.name);
        assertList(stmt.columns, 2);
        
        // -- CREATE INDEX index_name ON table_name()
        thrown.expect(ParseException.class);
        stmt = stmt("index3").createIndexStmt();
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
    
    private static HashMap<String, String> parts;
    
    private static void loadFile(final File file) throws IOException {
		String name = file.getName().substring(0, file.getName().length() - 4);		
    	BufferedReader reader = new BufferedReader(new FileReader(file));
		
    	int count = 0;
		String sql = null;
		
		while ((sql = reader.readLine()) != null) {
			count++;
			parts.put(name + count, sql);
		}
		reader.close();
    }
    
    static {
    	parts = new HashMap<String, String>();
  	
    	File[] files = new File("src/test/sqlipa/resources").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".sql");
            }
        });
    	    	
    	for (File file: files) {
			try {
				loadFile(file);
			} catch (IOException e) {
			}
    	}
    }
    
    private ASTParser parser(final String sql) {
        return new ASTParser(new StringReader(sql));
    }
    
    private ASTParser stmt(final String filename) {
        return parser(parts.get("s_" + filename));
    }
    
    private void assertList(List<? extends Node> nodes, int size) {
        assertTrue(nodes.size() == size);
        for (Node node : nodes) {
            assertNotNull(node);
        }
    }

}