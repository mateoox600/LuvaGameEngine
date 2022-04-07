package fr.mateoox600.game.lua.events.javaevents;

import com.raylib.java.core.rCore;
import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class OneSecondEvent extends JavaEvent {

    private float accumultator = 0;

    public OneSecondEvent() {
        super("1sEvent");
    }

    @Override
    public void update(EventUpdateHelper event) {
        this.accumultator += rCore.GetFrameTime();
        if(accumultator >= 1) {
            float delta = accumultator - 1;
            accumultator = 0;
            event.trigger(delta);
        }
    }

}



