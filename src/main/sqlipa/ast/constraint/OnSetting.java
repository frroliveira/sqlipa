package main.sqlipa.ast.constraint;

import main.sqlipa.ast.Block;
import main.sqlipa.ast.visitor.VoidVisitor;

public class OnSetting extends ForeignKeySetting {

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
    
    public OnSetting() {
        super();
    }
    
    public OnSetting(Block block, Event event, Action action) {
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

    @Override
    public void accept(VoidVisitor visitor) {
        visitor.visit(this);
    }

}