package main.sqlipa.parser.ast.constraint;

public class OnForeignKeySett extends ForeignKeySetting {

    public enum Event {
        DELETE,
        UPDATE
    }
    
    public enum Action {
        SET_NULL,
        SET_DEFAULT,
        CASCADE,
        RESTRICT,
        NO_ACTION
    }
    
    private Event event;
    
    private Action action;
    
    public OnForeignKeySett(int beginLine, int beginColumn, int endLine,
            int endColumn, Event event, Action action) {
        super(beginLine, beginColumn, endLine, endColumn);
        this.event = event;
        this.action = action;
    }

    public Event getEvent() {
        return event;
    }
    
    public Action getAction() {
        return action;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    public void setAction(Action action) {
        this.action = action;
    }
    
}