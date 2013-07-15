package main.sqlipa.parser.ast;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.TableName;

public class NotIndexedTableName extends QualifiedTableName {

    public NotIndexedTableName(Block block, DatabaseName db, TableName tab) {
        super(block, db, tab);
    }
    
}