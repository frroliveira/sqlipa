package main.sqlipa.ast.stmt.create;

import java.util.List;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.ModuleArgument;
import main.sqlipa.ast.Name;
import main.sqlipa.ast.visitor.VoidVisitor;

public class CreateVirtualTableStmt extends CreateStmt {
    
    public Name module;
    
    public List<ModuleArgument> arguments;
    
    public CreateVirtualTableStmt() {
        super();
    }
    
    public CreateVirtualTableStmt(Block block, Explain explain, boolean hasIfNotExists,
            Name database, Name name, Name module, List<ModuleArgument> arguments) {
        super(block, explain, hasIfNotExists, database, name);
        this.module = module;
        this.arguments = arguments;
    }

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}