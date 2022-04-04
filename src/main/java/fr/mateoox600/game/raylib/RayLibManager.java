package fr.mateoox600.game.raylib;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.events.JavaEvents;
import fr.mateoox600.game.lua.events.JavaEvent;

import java.io.IOException;

public class RayLibManager {

    private final Main main = Main.getInstance();

    public final Raylib raylib;
    public final Camera camera;

    public RayLibManager() {
        raylib = new Raylib();
        raylib.core.InitWindow(800, 600, "Game");
        raylib.core.SetTargetFPS(60);
        camera = new Camera();
    }

    public void start() throws IOException {

        boolean initialized = false;
        JavaEvent drawEvent = JavaEvents.getFromName("draw");
        JavaEvent drawUiEvent = JavaEvents.getFromName("drawUi");
        if(drawEvent == null) throw new Error("Critical error missing draw event");
        if(drawUiEvent == null) throw new Error("Critical error missing draw ui event");
        while (!raylib.core.WindowShouldClose()){
            if(!initialized) {
                initialized = true;
                main.luaManager.init();
            }

            main.luaManager.eventManager.update();

            raylib.core.BeginDrawing();
            raylib.core.ClearBackground(Color.WHITE);

            raylib.core.BeginMode2D(camera);

            main.luaManager.eventManager.execute(drawEvent);

            raylib.core.EndMode2D();

            raylib.text.DrawFPS(5, 5, Color.BLACK);

            main.luaManager.eventManager.execute(drawUiEvent);

            raylib.core.EndDrawing();
        }

        MemoryManager.free();
    }

}
