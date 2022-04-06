package fr.mateoox600.game.lua.bindings;

import com.raylib.java.core.input.Mouse;
import fr.mateoox600.game.lua.LuaPlatform;
import se.krka.kahlua.vm.KahluaTable;

public class MouseButton {

    public static KahluaTable getMouseButtonTable(LuaPlatform platform) {
        KahluaTable table = platform.newTable();

        table.rawset("MOUSE_BUTTON_LEFT", (double) Mouse.MouseButton.MOUSE_BUTTON_LEFT);
        table.rawset("MOUSE_BUTTON_RIGHT", (double) Mouse.MouseButton.MOUSE_BUTTON_RIGHT);
        table.rawset("MOUSE_BUTTON_MIDDLE", (double) Mouse.MouseButton.MOUSE_BUTTON_MIDDLE);

        return table;
    }

}
