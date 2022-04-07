package fr.mateoox600.game.lua.events.javaevents.input.key;

import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class KeyPressedEvent extends JavaEvent {

    private final Main main = Main.getInstance();

    public KeyPressedEvent() {
        super("keyPressed");
    }

    @Override
    public void update(EventUpdateHelper event) {
        for (int i = 0; i < 512; i++) {
            if(main.rayLibManager.raylib.core.IsKeyPressed(i)) {
                event.trigger((double) i);
            }
        }
    }

}
