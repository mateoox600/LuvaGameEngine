package fr.mateoox600.game.lua.bindings;

import com.raylib.java.core.Color;
import fr.mateoox600.game.lua.LuaPlatform;
import se.krka.kahlua.vm.JavaFunction;
import se.krka.kahlua.vm.KahluaTable;
import se.krka.kahlua.vm.KahluaUtil;

public class Colors {

    public static KahluaTable getColorTable(LuaPlatform platform) {
        KahluaTable table = platform.newTable();

        table.rawset("LIGHT_GRAY", Color.LIGHTGRAY);
        table.rawset("GRAY", Color.GRAY);
        table.rawset("DARK_GRAY", Color.DARKGRAY);
        table.rawset("YELLOW", Color.YELLOW);
        table.rawset("GOLD", Color.GOLD);
        table.rawset("ORANGE", Color.ORANGE);
        table.rawset("PINK", Color.PINK);
        table.rawset("RED", Color.RED);
        table.rawset("MAROON", Color.MAROON);
        table.rawset("GREEN", Color.GREEN);
        table.rawset("LIME", Color.LIME);
        table.rawset("DARK_GREEN", Color.DARKGREEN);
        table.rawset("SKY_BLUE", Color.SKYBLUE);
        table.rawset("BLUE", Color.BLUE);
        table.rawset("DARK_BLUE", Color.DARKBLUE);
        table.rawset("PURPLE", Color.PURPLE);
        table.rawset("VIOLET", Color.VIOLET);
        table.rawset("DARK_PURPLE", Color.DARKPURPLE);
        table.rawset("BEIGE", Color.BEIGE);
        table.rawset("BROWN", Color.BROWN);
        table.rawset("DARK_BROWN", Color.DARKBROWN);
        table.rawset("WHITE", Color.WHITE);
        table.rawset("BLACK", Color.BLACK);
        table.rawset("BLANK", Color.BLANK);
        table.rawset("MAGENTA", Color.MAGENTA);
        table.rawset("RAY_WHITE", Color.RAYWHITE);
        table.rawset("fromRGB", (JavaFunction) (luaCallFrame, argsNumber) -> {
            if(argsNumber == 3) {
                double r = KahluaUtil.getDoubleArg(luaCallFrame, 1, "fromRGB");
                double g = KahluaUtil.getDoubleArg(luaCallFrame, 2, "fromRGB");
                double b = KahluaUtil.getDoubleArg(luaCallFrame, 3, "fromRGB");
                luaCallFrame.push(new Color((int) r, (int) g, (int) b, 255));
            } else if(argsNumber == 4) {
                double r = KahluaUtil.getDoubleArg(luaCallFrame, 1, "fromRGB");
                double g = KahluaUtil.getDoubleArg(luaCallFrame, 2, "fromRGB");
                double b = KahluaUtil.getDoubleArg(luaCallFrame, 3, "fromRGB");
                double a = KahluaUtil.getDoubleArg(luaCallFrame, 4, "fromRGB");
                luaCallFrame.push(new Color((int) r, (int) g, (int) b, (int) a));
            } else throw new RuntimeException("Colors.fromRGB needs 3 or 4 arguments (red, green, blue and optional alpha)");
            return 1;
        });

        return table;
    }

}
