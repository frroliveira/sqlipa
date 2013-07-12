package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;
import main.sqlipa.parser.ast.stmt.SqlStatement;

public abstract class CreateStmt extends SqlStatement {

    boolean ifNotExists;
    DatabaseName db;
    Name name;
    
    public CreateStmt(Explain explain, boolean hasIfNotExists, DatabaseName db, 
            Name name) {
        super(explain);
        this.ifNotExists = hasIfNotExists;
        this.db = db;
        this.name = name;
    }

    public CreateStmt(int beginLine, int beginColumn, int endLine, 
            int endColumn, Explain explain, boolean hasIfNotExists, 
            DatabaseName db, Name name) {
        super(beginLine, beginColumn, endLine, endColumn, explain);
        this.ifNotExists = hasIfNotExists;
        this.db = db;
        this.name = name;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public Name getName() {
        return name;
    }
    
    public boolean hasIfNotExists() {
        return ifNotExists;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
    public void setIfNotExists(boolean hasIfNotExists) {
        this.ifNotExists = hasIfNotExists;
    }
    
}