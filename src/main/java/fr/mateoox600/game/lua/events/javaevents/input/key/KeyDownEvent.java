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
        for (int key = 0; key < 512; key++) {
            if(rCore.IsKeyDown(key)) {
                event.trigger((double) key);
            }
        }
    }

}
