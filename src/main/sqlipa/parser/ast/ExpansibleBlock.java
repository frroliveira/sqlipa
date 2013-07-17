package main.sqlipa.parser.ast;

public class ExpansibleBlock extends Block {
    
    public ExpansibleBlock() {
        super(-1, -1, -1, -1);
    }
    
    @Override
    public void setBeginLine(int beginLine) {
        if (getBeginLine() == -1)
            super.setBeginLine(beginLine);
    }
    
    @Override
    public void setBeginColumn(int beginColumn) {
        if (getBeginColumn() == -1)
            super.setBeginColumn(beginColumn);
    }
    
}