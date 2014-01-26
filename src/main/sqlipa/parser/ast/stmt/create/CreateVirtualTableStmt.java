package main.sqlipa.parser.ast.stmt.create;

import java.util.LinkedList;
import java.util.List;

import main.sqlipa.parser.ast.Block;
import main.sqlipa.parser.ast.ModuleArgument;
import main.sqlipa.parser.ast.name.DatabaseName;
import main.sqlipa.parser.ast.name.ModuleName;
import main.sqlipa.parser.ast.name.Name;

public class CreateVirtualTableStmt extends CreateStmt {
    
    private ModuleName module;
    
    private List<ModuleArgument> args;
    
    public CreateVirtualTableStmt() {
        super();
        this.args = new LinkedList<ModuleArgument>();
    }
    
    public CreateVirtualTableStmt(Block block, Explain explain,
            boolean hasIfNotExists, DatabaseName db, Name name,
            ModuleName module, List<ModuleArgument> args) {
        super(block, explain, hasIfNotExists, db, name);
        this.module = module;
        this.args = args;
    }
    
    public ModuleName getModule() {
        return module;
    }
    
    public List<ModuleArgument> getModuleArguments() {
        return args;
    }
    
    public void setModule(ModuleName module) {
        this.module = module;
    }
    
    public void setModuleArguments(List<ModuleArgument> args) {
        this.args = args;
    }
    
    public void addModuleArgument(ModuleArgument arg) {
        args.add(arg);
    }
    
    public boolean removeModuleArgument(ModuleArgument arg) {
        return args.remove(arg);
    }

}