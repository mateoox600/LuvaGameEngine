package fr.mateoox600.game.lua.events;

public abstract class JavaEvent {

    public final String name;

    public JavaEvent(String name) {
        this.name = name;
    }

    protected abstract void update(EventUpdateHelper event);

}
