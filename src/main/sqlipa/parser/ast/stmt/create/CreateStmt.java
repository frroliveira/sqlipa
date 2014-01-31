package main.sqlipa.parser.ast.stmt.create;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.Name;
import main.sqlipa.parser.ast.stmt.SqlStatement;
import main.sqlipa.parser.ast.visitor.VoidVisitor;

public abstract class CreateStmt extends SqlStatement {

    private boolean ifNotExists;
    
    private Name database;
    
    private Name name;
    
    public CreateStmt() {
        super();
    }
    
    public CreateStmt(Block block, Explain explain, boolean hasIfNotExists, 
            Name database, Name name) {
        super(block, explain);
        this.ifNotExists = hasIfNotExists;
        this.database = database;
        this.name = name;
    }

    public Name getDatabase() {
        return database;
    }
    
    public Name getName() {
        return name;
    }
    
    public boolean hasIfNotExists() {
        return ifNotExists;
    }
    
    public void setDatabase(Name database) {
        this.database = database;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
    public void setIfNotExists(boolean hasIfNotExists) {
        this.ifNotExists = hasIfNotExists;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}