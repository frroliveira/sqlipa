package main.sqlipa.parser.ast.constraint;

import main.sqlipa.parser.ast.Block;

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
    
    public OnForeignKeySett(Block block, Event event, Action action) {
        super(block);
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