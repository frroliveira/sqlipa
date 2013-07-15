package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class NotIndexedTableName extends QualifiedTableName {

    public NotIndexedTableName(int beginLine, int beginColumn, int endLine,
            int endColumn, DatabaseName db, TableName tab) {
        super(beginLine, beginColumn, endLine, endColumn, db, tab);
    }
    
}