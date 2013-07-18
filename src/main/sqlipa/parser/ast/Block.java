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
    
    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }
    
    public void setBeginColumn(int beginColumn) {
        this.beginColumn = beginColumn;
    }
    
    public void setBegin(int beginLine, int beginColumn) {
        setBeginLine(beginLine);
        setBeginColumn(beginColumn);
    }
    
    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }
    
    public void setEndColumn(int endColumn) {
        this.endColumn = endColumn;
    }
    
    public void setEnd(int endLine, int endColumn) {
        setEndLine(endLine);
        setEndColumn(endColumn);
    }
    
    public void setValues(int beginLine, int beginColumn, int endLine, 
            int endColumn) {
        setBeginLine(beginLine);
        setBeginColumn(beginColumn);
        setEndLine(endLine);
        setEndColumn(endColumn);
    }
    
}