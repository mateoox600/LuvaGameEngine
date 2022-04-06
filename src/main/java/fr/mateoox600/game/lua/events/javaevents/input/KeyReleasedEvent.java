package fr.mateoox600.game.lua.events.javaevents.input;

import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.events.JavaEvent;

public class KeyReleasedEvent implements JavaEvent {

    private final Main main = Main.getInstance();
    private int key = -1;

    @Override
    public String getName() {
        return "keyReleased";
    }

    @Override
    public boolean checkExecute() {
        for (int i = 0; i < 512; i++) {
            if(main.rayLibManager.raylib.core.IsKeyReleased(i)) {
                key = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] getArguments() {
        return new Object[] { (double) key };
    }

}
