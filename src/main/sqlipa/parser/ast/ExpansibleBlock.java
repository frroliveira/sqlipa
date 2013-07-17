package main.sqlipa.parser.ast;

public class ExpansibleBlock extends Block {
    
    public ExpansibleBlock() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE,
                Integer.MIN_VALUE);
    }
    
    public ExpansibleBlock(int beginLine, int beginColumn, int endLine,
            int endColumn) {
        super(beginLine, beginColumn, endLine, endColumn);
    }
    
    @Override
    public void setBeginLine(int beginLine) {
        if (beginLine < this.beginLine)
            this.beginLine = beginLine;
    }
    
    @Override
    public void setBeginColumn(int beginColumn) {
        if (beginColumn < this.beginColumn)
            this.beginColumn = beginColumn;
    }
    
    @Override
    public void setEndLine(int endLine) {
        if (endLine > this.endLine)
            this.endLine = endLine;
    }
    
    @Override
    public void setEndColumn(int endColumn) {
        if (endColumn > this.endColumn)
            this.endColumn = endColumn;
    }
    
}