package fr.mateoox600.game.lua.events;

import fr.mateoox600.game.lua.events.javaevents.DrawUiEvent;
import fr.mateoox600.game.lua.events.javaevents.UpdateEvent;
import fr.mateoox600.game.lua.events.javaevents.input.MouseButtonPressedEvent;
import fr.mateoox600.game.lua.events.javaevents.DrawEvent;
import fr.mateoox600.game.lua.events.javaevents.input.KeyPressedEvent;
import fr.mateoox600.game.lua.events.javaevents.OneSecondEvent;
import fr.mateoox600.game.lua.events.javaevents.input.KeyReleasedEvent;
import fr.mateoox600.game.lua.events.javaevents.input.MouseButtonReleasedEvent;

public class JavaEvents {

    private static final JavaEvent[] events = new JavaEvent[] {
            new UpdateEvent(),
            new DrawEvent(),
            new DrawUiEvent(),
            new OneSecondEvent(),
            new MouseButtonPressedEvent(),
            new MouseButtonReleasedEvent(),
            new KeyPressedEvent(),
            new KeyReleasedEvent()
    };

    public static JavaEvent[] getEvents() {
        return events;
    }

    public static JavaEvent getFromName(String name) {
        for(JavaEvent e : getEvents()) {
            if(e.getName().equals(name)) return e;
        }
        return null;
    }

}
