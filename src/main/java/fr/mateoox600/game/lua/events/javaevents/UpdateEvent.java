package fr.mateoox600.game.lua.events.javaevents;

import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class UpdateEvent extends JavaEvent {

    public UpdateEvent() {
        super("update");
    }

    @Override
    public void update(EventUpdateHelper event) {
        event.trigger();
    }

}
