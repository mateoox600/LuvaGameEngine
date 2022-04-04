package fr.mateoox600.game.lua.bindings;

import com.raylib.java.core.rCore;
import fr.mateoox600.game.Main;
import se.krka.kahlua.integration.annotations.LuaMethod;
import se.krka.kahlua.vm.KahluaTable;

public class Input {

    private final Main main = Main.getInstance();

    @LuaMethod(name = "isKeyDown")
    public boolean isKeyDown(double key) {
        return rCore.IsKeyDown((int) key);
    }

    @LuaMethod(name = "isKeyUp")
    public boolean isKeyUp(double key) {
        return main.rayLibManager.raylib.core.IsKeyUp((int) key);
    }

    @LuaMethod(name = "isMouseButtonDown")
    public boolean isMouseButtonDown(double key) {
        return rCore.IsMouseButtonDown((int) key);
    }

    @LuaMethod(name = "isMouseButtonUp")
    public boolean isMouseButtonUp(double key) {
        return main.rayLibManager.raylib.core.IsMouseButtonUp((int) key);
    }

    @LuaMethod(name = "getMouseWheelDelta")
    public double getMouseWheelDelta() {
        return rCore.GetMouseWheelMove();
    }

    @LuaMethod(name = "getMousePosition")
    public KahluaTable getMousePosition() {
        KahluaTable table = main.luaManager.platform.newTable();
        table.rawset("x", main.rayLibManager.raylib.core.GetMouseX());
        table.rawset("y", main.rayLibManager.raylib.core.GetMouseY());
        return table;
    }

    @LuaMethod(name = "getMouseDelta")
    public KahluaTable getMouseDelta() {
        KahluaTable table = main.luaManager.platform.newTable();
        table.rawset("x", main.rayLibManager.raylib.core.GetMouseDelta().x);
        table.rawset("y", main.rayLibManager.raylib.core.GetMouseDelta().y);
        return table;
    }

}
