package fr.mateoox600.game.lua.events.javaevents;

import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class DrawEvent implements JavaEvent {

    @Override
    public String getName() {
        return "draw";
    }

    @Override
    public void update(EventUpdateHelper event) { }

}
