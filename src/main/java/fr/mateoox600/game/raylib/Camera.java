package fr.mateoox600.game.raylib;

import com.raylib.java.core.camera.Camera2D;
import com.raylib.java.raymath.Vector2;
import fr.mateoox600.game.Main;
import se.krka.kahlua.integration.annotations.LuaMethod;
import se.krka.kahlua.vm.KahluaTable;

public class Camera extends Camera2D {

    private final Main main = Main.getInstance();

    public Camera() {
        super();
        this.rotation = 0;
        this.zoom = 1;
    }

    @LuaMethod(name = "setTarget")
    public void setTarget(double x, double y) {
        this.setTarget(new Vector2((int) x, (int) y));
    }

    @LuaMethod(name = "getTarget")
    public KahluaTable getCameraTarget() {
        KahluaTable returns = main.luaManager.platform.newTable();
        returns.rawset("x", (double) this.target.x);
        returns.rawset("y", (double) this.target.y);
        return returns;
    }

    @LuaMethod(name = "setOffset")
    public void setOffset(double x, double y) {
        this.setOffset(new Vector2((int) x, (int) y));
    }

    @LuaMethod(name = "getOffset")
    public KahluaTable getCameraOffset() {
        KahluaTable returns = main.luaManager.platform.newTable();
        returns.rawset("x", (double) this.offset.x);
        returns.rawset("y", (double) this.offset.y);
        return returns;
    }

    @LuaMethod(name = "setRotation")
    public void setRotation(double rotation) {
        this.setRotation((float) rotation);
    }

    @LuaMethod(name = "getRotation")
    public double getCameraRotation() {
        return this.rotation;
    }

    @LuaMethod(name = "setZoom")
    public void setZoom(double zoom) {
        this.setZoom((float) zoom);
    }

    @LuaMethod(name = "getZoom")
    public double getCameraZoom() {
        return this.zoom;
    }

    @LuaMethod(name = "getWorldToScreen2D")
    public KahluaTable getWorldToScreen2D(double x, double y) {
        KahluaTable returns = main.luaManager.platform.newTable();
        Vector2 v = main.rayLibManager.raylib.core.GetWorldToScreen2D(new Vector2((int) x, (int) y), this);
        returns.rawset("x", (double) v.x);
        returns.rawset("y", (double) v.y);
        return returns;
    }

    @LuaMethod(name = "getScreenToWorld2D")
    public KahluaTable getScreenToWorld2D(double x, double y) {
        KahluaTable returns = main.luaManager.platform.newTable();
        Vector2 v = main.rayLibManager.raylib.core.GetScreenToWorld2D(new Vector2((int) x, (int) y), this);
        returns.rawset("x", (double) v.x);
        returns.rawset("y", (double) v.y);
        return returns;
    }

}
