package fr.mateoox600.game.lua.events;

import fr.mateoox600.game.Main;

public class EventUpdateHelper {

    private final Main main = Main.getInstance();
    public final String eventName;

    public EventUpdateHelper(String eventName) {
        this.eventName = eventName;
    }

    public EventUpdateHelper(JavaEvent eventName) {
        this(eventName.getName());
    }

    public void trigger(Object ...args) {
        main.luaManager.eventManager.execute(eventName, args);
    }

}