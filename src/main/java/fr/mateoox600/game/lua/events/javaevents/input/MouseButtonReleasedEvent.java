package fr.mateoox600.game.lua.events.javaevents.input;

import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class MouseButtonReleasedEvent extends JavaEvent {

    private final Main main = Main.getInstance();

    public MouseButtonReleasedEvent() {
        super("mouseButtonReleased");
    }

    @Override
    public void update(EventUpdateHelper event) {
        for (int i = 0; i < 3; i++) {
            if(main.rayLibManager.raylib.core.IsMouseButtonReleased(i)) {
                event.trigger((double) i);
            }
        }
    }

}
