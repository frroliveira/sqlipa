package main.sqlipa.parser.ast;

public class Block {
    
    protected int beginLine;
    
    private int beginColumn;
    
    private int endLine;
    
    private int endColumn;
    
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
    
    public final void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }
    
    public final void setBeginColumn(int beginColumn) {
        this.beginColumn = beginColumn;
    }
    
    public final void setEndLine(int endLine) {
        this.endLine = endLine;
    }
    
    public final void setEndColumn(int endColumn) {
        this.endColumn = endColumn;
    }
    
}