package main.sqlipa.parser.ast.stmt;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.Name;

public class AnalyzeStmt extends SqlStatement {
    
    private DatabaseName db;
    
    private Name tabOrInd;
    
    public AnalyzeStmt() {
        super();
    }
    
    public AnalyzeStmt(Block block, Explain explain, DatabaseName db,
            Name tabOrInd) {
        super(block, explain);
        this.db = db;
        this.tabOrInd = tabOrInd;
    }
    
    public DatabaseName getDatabase() {
        return db;
    }
    
    public Name getTableOrIndex() {
        return tabOrInd;
    }
    
    public void setDatabase(DatabaseName db) {
        this.db = db;
    }
    
    public void setTableOrIndex(Name tabOrInd) {
        this.tabOrInd = tabOrInd;
    }

}