package fr.mateoox600.game.raylib;

import com.raylib.java.core.Color;
import com.raylib.java.textures.Texture2D;
import fr.mateoox600.game.Main;
import se.krka.kahlua.integration.annotations.LuaMethod;

public class RayDrawer {

    private final Main main = Main.getInstance();

    @LuaMethod(name = "drawRect")
    public void drawRect(double x, double y, double width, double height, Color color) {
        main.rayLibManager.raylib.shapes.DrawRectangle((int) x, (int) y, (int) width, (int) height, color);
    }

    @LuaMethod(name = "drawText")
    public void drawText(String text, double x, double y, double fontSize, Color color) {
        main.rayLibManager.raylib.text.DrawText(text, (int) x, (int) y, (int) fontSize, color);
    }

    @LuaMethod(name = "measureText")
    public double measureText(String text, double fontSize) {
        return main.rayLibManager.raylib.text.MeasureText(text, (int) fontSize);
    }

    @LuaMethod(name = "drawTexture")
    public void drawTexture(Texture2D texture, double x, double y, Color color) {
        main.rayLibManager.raylib.textures.DrawTexture(texture, (int) x, (int) y, color);
    }

}
