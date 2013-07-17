package main.sqlipa.parser.ast;

public class Block {
    
    protected int beginLine;
    
    private int beginColumn;
    
    private int endLine;
    
    private int endColumn;
    
    public Block() {
    }
    
    public Block(int beginLine, int beginColumn, int endLine, int endColumn) {
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }
    
    public final int getBeginLine() {
        return beginLine;
    }
    
    public final int getBeginColumn() {
        return beginColumn;
    }
    
    public final int getEndLine() {
        return endLine;
    }
    
    public final int getEndColumn() {
        return endColumn;
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
    
}