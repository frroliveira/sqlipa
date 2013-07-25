package main.sqlipa.parser.ast;

public class Block {
    
    public int beginLine;
    
    public int beginColumn;
    
    public int endLine;
    
    public int endColumn;
    
    public Block() {
    }
    
    public Block(int beginLine, int beginColumn, int endLine, int endColumn) {
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public void setBegin(int beginLine, int beginColumn) {
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
    }
    
    public void setEnd(int endLine, int endColumn) {
        this.endLine = endLine;
        this.endColumn = endColumn;
    }
    
    public void setBeginEnd(Block block) {
        if (block != null) {
            setBeginEnd(block.beginLine, block.beginColumn, block.endLine,
                    block.endColumn);
        }
    }
    
    public void setBeginEnd(int beginLine, int beginColumn, int endLine, 
            int endColumn) {
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

}