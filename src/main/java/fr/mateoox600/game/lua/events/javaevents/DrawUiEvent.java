package fr.mateoox600.game.lua.events.javaevents;

import fr.mateoox600.game.lua.events.JavaEvent;
import fr.mateoox600.game.raylib.RayDrawer;

public class DrawUiEvent implements JavaEvent {

    private final RayDrawer drawer = new RayDrawer();

    @Override
    public String getName() {
        return "drawUi";
    }

    @Override
    public boolean checkExecute() {
        return false;
    }

    @Override
    public Object[] getArguments() {
        return new Object[] { drawer };
    }

}
