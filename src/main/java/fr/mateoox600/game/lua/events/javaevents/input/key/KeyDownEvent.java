package fr.mateoox600.game.lua.events.javaevents.input.key;

import com.raylib.java.core.rCore;
import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class KeyDownEvent extends JavaEvent {

    public KeyDownEvent() {
        super("keyDown");
    }

    @Override
    public void update(EventUpdateHelper event) {
        for (int i = 0; i < 512; i++) {
            if(rCore.IsKeyDown(i)) {
                event.trigger((double) i);
            }
        }
    }

}
