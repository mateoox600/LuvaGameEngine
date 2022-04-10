package fr.mateoox600.game.raylib;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import fr.mateoox600.game.Main;

import java.io.IOException;

public class RayLibManager {

    private final Main main = Main.getInstance();

    public final Raylib raylib;
    public final Camera camera;
    public final RayDrawer drawer = new RayDrawer();

    public RayLibManager() {
        raylib = new Raylib();
        raylib.core.InitWindow(800, 600, "Game");
        raylib.core.SetTargetFPS(60);
        camera = new Camera();
    }

    public void start() throws IOException {

        boolean initialized = false;
        while (!raylib.core.WindowShouldClose()){
            if(!initialized) {
                initialized = true;
                main.luaManager.init();
            }

            main.luaManager.eventManager.update();

            raylib.core.BeginDrawing();
            raylib.core.ClearBackground(new Color(40, 42, 54, 255));

            raylib.core.BeginMode2D(camera);

            main.luaManager.eventManager.execute("draw", drawer);

            raylib.core.EndMode2D();

            main.luaManager.eventManager.execute("drawUi", drawer);

            raylib.core.EndDrawing();
        }

        MemoryManager.free();
    }

}
