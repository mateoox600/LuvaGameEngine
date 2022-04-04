package fr.mateoox600.game.lua;

import com.raylib.java.core.Color;
import com.raylib.java.textures.Texture2D;
import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.bindings.*;
import fr.mateoox600.game.lua.events.EventManager;
import fr.mateoox600.game.lua.resources.LuaFileUtils;
import fr.mateoox600.game.raylib.Camera;
import fr.mateoox600.game.raylib.RayDrawer;
import se.krka.kahlua.converter.KahluaConverterManager;
import se.krka.kahlua.integration.LuaCaller;
import se.krka.kahlua.integration.expose.LuaJavaClassExposer;
import se.krka.kahlua.vm.KahluaTable;
import se.krka.kahlua.vm.KahluaThread;

import java.io.IOException;

public class LuaManager {

    private final Main main = Main.getInstance();

    private final String mainPath;

    public final KahluaConverterManager converterManager;
    public final LuaPlatform platform;
    public final KahluaTable env;
    public final KahluaThread thread;
    public final LuaCaller caller;
    public final LuaJavaClassExposer exposer;
    public final EventManager eventManager;

    public LuaManager(String mainPath) {
        this.mainPath = mainPath;
        converterManager = new KahluaConverterManager();
        platform = LuaPlatform.getInstance();
        env = platform.newEnvironment();
        thread = new KahluaThread(platform, env);
        caller = new LuaCaller(converterManager);
        exposer = new LuaJavaClassExposer(converterManager, platform, env);
        eventManager = new EventManager();
    }

    public void init() throws IOException {
        exposer.exposeGlobalFunctions(new GlobalLib());
        exposer.exposeClass(Camera.class);
        exposer.exposeClass(RayDrawer.class);
        exposer.exposeClass(Color.class);
        exposer.exposeClass(Texture2D.class);

        env.rawset("camera", main.rayLibManager.camera);
        env.rawset("Colors", Colors.getColorTable(platform));
        env.rawset("MouseButton", MouseButton.getMouseButtonTable(platform));
        env.rawset("KeyboardButton", KeyboardButton.getKeyboardButtonTable(platform));
        env.rawset("Input", new Input());

        LuaFileUtils.executeLuaFile(mainPath);
    }

}
