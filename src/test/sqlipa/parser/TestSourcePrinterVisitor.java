package test.sqlipa.parser;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.sqlipa.ast.stmt.SqlStmtList;
import main.sqlipa.ast.visitor.SourcePrinterVisitor;
import main.sqlipa.parser.ASTParser;
import main.sqlipa.parser.ParseException;

import org.junit.Test;

public class TestSourcePrinterVisitor {
	
    @Test
    public void testAllFiles() throws ParseException {
    	for (String part: mHelper.getAll()) {
    		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        	SourcePrinterVisitor printer = new SourcePrinterVisitor(new PrintStream(stream));

        	ASTParser parser = new ASTParser(new ByteArrayInputStream(part.getBytes()));
			SqlStmtList stmts = parser.sqlStmtList();
			
			stmts.accept(printer);
			assertEquals(part, stream.toString());
    	}    	
    }
    
    private TestHelper mHelper = new TestHelper();

}