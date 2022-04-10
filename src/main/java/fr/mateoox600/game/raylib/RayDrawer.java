package fr.mateoox600.game.raylib;

import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import fr.mateoox600.game.Main;
import se.krka.kahlua.integration.annotations.LuaMethod;

public class RayDrawer {

    private final Main main = Main.getInstance();

    @LuaMethod(name = "drawPixel")
    public void drawPixel(double x, double y, Color color) {
        main.rayLibManager.raylib.shapes.DrawPixel((int) x, (int) y, color);
    }

    @LuaMethod(name = "drawLine")
    public void drawLine(double xFrom, double yFrom, double xTo, double yTo, double lineWidth, Color color) {
        main.rayLibManager.raylib.shapes.DrawLineEx(new Vector2((int) xFrom, (int) yFrom), new Vector2((int) xTo, (int) yTo), (int) lineWidth, color);
    }

    @LuaMethod(name = "fillCircle")
    public void fillCircle(double x, double y, double radius, Color color) {
        main.rayLibManager.raylib.shapes.DrawCircle((int) x, (int) y, (int) radius, color);
    }

    @LuaMethod(name = "strokeCircle")
    public void strokeCircle(double x, double y, double radius, Color color) {
        main.rayLibManager.raylib.shapes.DrawCircleLines((int) x, (int) y, (int) radius, color);
    }

    @LuaMethod(name = "fillEllipse")
    public void fillEllipse(double x, double y, double radiusWidth, double radiusHeight, Color color) {
        main.rayLibManager.raylib.shapes.DrawEllipse((int) x, (int) y, (int) radiusWidth, (int) radiusHeight, color);
    }

    @LuaMethod(name = "strokeEllipse")
    public void strokeEllipse(double x, double y, double radiusWidth, double radiusHeight, Color color) {
        main.rayLibManager.raylib.shapes.DrawEllipseLines((int) x, (int) y, (int) radiusWidth, (int) radiusHeight, color);
    }

    @LuaMethod(name = "fillRing")
    public void fillRing(double x, double y, double innerRadius, double outerRadius, double startAngle, double endAngle, double segments, Color color) {
        main.rayLibManager.raylib.shapes.DrawRing(new Vector2((int) x, (int) y), (int) innerRadius, (int) outerRadius, (int) startAngle, (int) endAngle, (int) segments, color);
    }

    @LuaMethod(name = "strokeRing")
    public void strokeRing(double x, double y, double innerRadius, double outerRadius, double startAngle, double endAngle, double segments, Color color) {
        main.rayLibManager.raylib.shapes.DrawRingLines(new Vector2((int) x, (int) y), (int) innerRadius, (int) outerRadius, (int) startAngle, (int) endAngle, (int) segments, color);
    }

    @LuaMethod(name = "fillRect")
    public void fillRect(double x, double y, double width, double height, Color color) {
        main.rayLibManager.raylib.shapes.DrawRectangle((int) x, (int) y, (int) width, (int) height, color);
    }

    @LuaMethod(name = "strokeRect")
    public void strokeRect(double x, double y, double width, double height, double lineWidth, Color color) {
        main.rayLibManager.raylib.shapes.DrawRectangleLinesEx(new Rectangle((int) x, (int) y, (int) width, (int) height), (int) lineWidth, color);
    }

    @LuaMethod(name = "fillPoly")
    public void fillPoly(double x, double y, double sides, double radius, double rotation, Color color) {
        main.rayLibManager.raylib.shapes.DrawPoly(new Vector2((int) x, (int) y), (int) sides, (int) radius, (int) rotation, color);
    }

    @LuaMethod(name = "strokePoly")
    public void strokePoly(double x, double y, double sides, double radius, double rotation, double lineWidth, Color color) {
        main.rayLibManager.raylib.shapes.DrawPolyLinesEx(new Vector2((int) x, (int) y), (int) sides, (int) radius, (int) rotation, (int) lineWidth, color);
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
