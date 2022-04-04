package fr.mateoox600.game.lua.events.javaevents.input;

import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.events.JavaEvent;

public class MouseButtonReleasedEvent implements JavaEvent {

    private final Main main = Main.getInstance();
    private int button = -1;

    @Override
    public String getName() {
        return "mouseButtonReleased";
    }

    @Override
    public boolean checkExecute() {
        for (int i = 0; i < 3; i++) {
            if(main.rayLibManager.raylib.core.IsMouseButtonReleased(i)) {
                button = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] getArguments() {
        return new Object[] {
                (double) button,
                (double) main.rayLibManager.raylib.core.GetMouseX(),
                (double) main.rayLibManager.raylib.core.GetMouseY()
        };
    }

}
