package fr.mateoox600.game.lua.events;

import se.krka.kahlua.vm.LuaClosure;

public record Event(String name, LuaClosure function) {

}
