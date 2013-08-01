package main.sqlipa.parser.ast;

public class Block {
    
    public int beginLine;
    
    public int beginColumn;
    
    public int endLine;
    
    public int endColumn;
    
    public Block() {
    }
    
    public Block(Block block) {
        this(block.beginLine, block.beginColumn, block.endLine,
                block.endColumn);
    }
    
    public Block(int beginLine, int beginColumn, int endLine, int endColumn) {
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public void setBegin(Block block) {
        setBegin(block.beginLine, block.beginColumn);
    }
    
    public void setBegin(int beginLine, int beginColumn) {
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
    }
    
    public void setEnd(Block block) {
        setEnd(block.endLine, block.endColumn);
    }
    
    public void setEnd(int endLine, int endColumn) {
        this.endLine = endLine;
        this.endColumn = endColumn;
    }
    
    public void setBeginEnd(Block block) {
        setBeginEnd(block.beginLine, block.beginColumn, block.endLine,
                block.endColumn);
    }
    
    public void setBeginEnd(int beginLine, int beginColumn, int endLine, 
            int endColumn) {
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

}