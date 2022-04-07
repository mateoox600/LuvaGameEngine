package fr.mateoox600.game.lua.events.javaevents.input;

import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.events.EventUpdateHelper;
import fr.mateoox600.game.lua.events.JavaEvent;

public class MouseButtonPressedEvent extends JavaEvent {

    private final Main main = Main.getInstance();

    public MouseButtonPressedEvent() {
        super("mouseButtonPressed");
    }

    @Override
    public void update(EventUpdateHelper event) {
        for (int i = 0; i < 3; i++) {
            if(main.rayLibManager.raylib.core.IsMouseButtonPressed(i)) {
                event.trigger((double) i, (double) main.rayLibManager.raylib.core.GetMouseX(), (double) main.rayLibManager.raylib.core.GetMouseY());
            }
        }
    }

}
