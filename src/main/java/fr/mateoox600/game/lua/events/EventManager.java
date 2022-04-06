package fr.mateoox600.game.lua.events;

import fr.mateoox600.game.lua.resources.LuaFileUtils;
import se.krka.kahlua.vm.LuaClosure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EventManager {

    private final HashMap<String, ArrayList<Event>> events = new HashMap<>();

    public void update() {
        Arrays.stream(JavaEvents.getEvents()).forEach((javaEvent) -> javaEvent.update(new EventUpdateHelper(javaEvent)));
    }

    public void execute(String event, Object ...args) {
        if(events.containsKey(event)) {
            events.get(event).forEach((e) -> LuaFileUtils.executeLuaClosure(e.function(), args));
        }
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