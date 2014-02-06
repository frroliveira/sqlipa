package test.sqlipa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.sqlipa.parser.TestASTParser;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
        TestASTParser.class
})
public class All {
}