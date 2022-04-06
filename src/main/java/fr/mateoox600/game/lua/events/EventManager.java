package fr.mateoox600.game.lua.events;

import fr.mateoox600.game.lua.resources.LuaFileUtils;
import se.krka.kahlua.vm.LuaClosure;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {

    private final HashMap<String, ArrayList<Event>> events = new HashMap<>();

    public void update() {
        for(JavaEvent event : JavaEvents.getEvents()) {
            if(event.checkExecute()) execute(event);
        }
    }

    public void execute(String event, Object ...args) {
        if(events.containsKey(event)) {
            events.get(event).forEach((e) -> LuaFileUtils.executeLuaClosure(e.function(), args));
        }
    }

    public void execute(JavaEvent event) {
        execute(event.getName(), event.getArguments());
    }

    public void addEvent(String eventType, LuaClosure function) {
        Event event = new Event(eventType, function);
        if(events.containsKey(eventType)) events.get(eventType).add(event);
        else {
            ArrayList<Event> list = new ArrayList<>();
            list.add(event);
            events.put(eventType, list);
        }
    }

}
