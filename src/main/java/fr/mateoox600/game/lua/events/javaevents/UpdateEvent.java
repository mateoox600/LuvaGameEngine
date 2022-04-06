package fr.mateoox600.game.lua.events.javaevents;

import com.raylib.java.core.rCore;
import fr.mateoox600.game.lua.events.JavaEvent;

public class UpdateEvent implements JavaEvent {

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public boolean checkExecute() {
        return true;
    }

    @Override
    public Object[] getArguments() {
        return new Object[] {
                rCore.GetFrameTime()
        };
    }

}
