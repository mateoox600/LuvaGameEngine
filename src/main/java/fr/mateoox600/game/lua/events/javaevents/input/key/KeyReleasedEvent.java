package fr.mateoox600.game.lua.events.javaevents.input.key;

import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class KeyReleasedEvent extends JavaEvent {

    private final Main main = Main.getInstance();

    public KeyReleasedEvent() {
        super("keyReleased");
    }

    @Override
    public void update(EventUpdateHelper event) {
        for (int key = 0; key < 512; key++) {
            if(main.rayLibManager.raylib.core.IsKeyReleased(key)) {
                event.trigger((double) key);
            }
        }
    }

}
