package fr.mateoox600.game.lua.events.javaevents;

import com.raylib.java.core.rCore;
import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class OneSecondEvent extends JavaEvent {

    private float acc = 0;

    public OneSecondEvent() {
        super("1sEvent");
    }

    @Override
    public void update(EventUpdateHelper event) {
        this.acc += rCore.GetFrameTime();
        if(acc >= 1) {
            float miss = acc - 1;
            acc = 0;
            event.trigger(miss);
        }
    }

}



