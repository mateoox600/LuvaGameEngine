package fr.mateoox600.game.lua.events;

public interface JavaEvent {

    String getName();

    void update(EventUpdateHelper event);

}
