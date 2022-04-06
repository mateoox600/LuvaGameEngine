package fr.mateoox600.game.raylib;

import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import fr.mateoox600.game.Main;
import se.krka.kahlua.integration.annotations.LuaMethod;

public class RayDrawer {

    private final Main main = Main.getInstance();

    @LuaMethod(name = "drawPixel")
    public void drawPixel(double x, double y, Color color) {
        main.rayLibManager.raylib.shapes.DrawPixel((int) x, (int) y, color);
    }

    @LuaMethod(name = "drawLine")
    public void drawLine(double x1, double y1, double x2, double y2, Color color) {
        main.rayLibManager.raylib.shapes.DrawLine((int) x1, (int) y1, (int) x2, (int) y2, color);
    }

    @LuaMethod(name = "drawCircle")
    public void drawCircle(double x, double y, double radius, Color color) {
        main.rayLibManager.raylib.shapes.DrawCircle((int) x, (int) y, (int) radius, color);
    }

    @LuaMethod(name = "drawEllipse")
    public void drawEllipse(double x, double y, double radiusH, double radiusV, Color color) {
        main.rayLibManager.raylib.shapes.DrawEllipse((int) x, (int) y, (int) radiusH, (int) radiusV, color);
    }

    @LuaMethod(name = "drawRing")
    public void drawRing(double x, double y, double innerRadius, double outerRadius, double startAngle, double endAngle, double segments, Color color) {
        main.rayLibManager.raylib.shapes.DrawRing(new Vector2((int) x, (int) y), (int) innerRadius, (int) outerRadius, (int) startAngle, (int) endAngle, (int) segments, color);
    }

    @LuaMethod(name = "drawRect")
    public void drawRect(double x, double y, double width, double height, Color color) {
        main.rayLibManager.raylib.shapes.DrawRectangle((int) x, (int) y, (int) width, (int) height, color);
    }

    @LuaMethod(name = "drawPoly")
    public void drawPoly(double x, double y, double sides, double radius, double rotation, Color color) {
        main.rayLibManager.raylib.shapes.DrawPoly(new Vector2((int) x, (int) y), (int) sides, (int) radius, (int) rotation, color);
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
    public void drawTexture(Texture texture, double x, double y, Color color) {
        main.rayLibManager.raylib.textures.DrawTexture(texture.texture, (int) x, (int) y, color);
    }

}
