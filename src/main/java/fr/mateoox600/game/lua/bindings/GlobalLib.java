package fr.mateoox600.game.lua.bindings;

import com.raylib.java.core.rCore;
import com.raylib.java.textures.Image;
import com.raylib.java.textures.rTextures;
import fr.mateoox600.game.Main;
import fr.mateoox600.game.lua.resources.LuaFileUtils;
import fr.mateoox600.game.lua.resources.ResourceLoader;
import fr.mateoox600.game.raylib.MemoryManager;
import fr.mateoox600.game.raylib.Texture;
import se.krka.kahlua.integration.LuaReturn;
import se.krka.kahlua.integration.annotations.LuaMethod;
import se.krka.kahlua.vm.LuaClosure;

import java.io.IOException;

public class GlobalLib {

    private final Main main = Main.getInstance();

    @LuaMethod(name = "require", global = true)
    public Object require(String file) throws IOException {
        LuaReturn end = LuaFileUtils.executeLuaFile(file);
        return end.size() >= 1 ? end.getFirst() : null;
    }

    @LuaMethod(name = "use", global = true)
    public void use(String file) throws IOException {
        LuaFileUtils.executeLuaFile(file);
    }

    @LuaMethod(name = "load", global = true)
    public Texture load(String path) {
        Image image = rTextures.LoadImage(ResourceLoader.loadResource(path).getPath().toString());
        Texture texture = new Texture(image);
        MemoryManager.loadedTextures.add(texture);
        return texture;
    }

    @LuaMethod(name = "pipe", global = true)
    public Object pipe(Object in, LuaClosure ...steps) {
        Object result = in;
        for (LuaClosure closure : steps) {
            LuaReturn returns = LuaFileUtils.executeLuaClosure(closure, result);
            result = returns.size() >= 1 ? returns.getFirst() : null;
        }
        return result;
    }

    @LuaMethod(name = "on", global = true)
    public void on(String name, LuaClosure function) {
        if(name == null || function == null) return;
        main.luaManager.eventManager.addEvent(name, function);
    }

    @LuaMethod(name = "emitEvent", global = true)
    public void emitEvent(String name, Object ...args) {
        main.luaManager.eventManager.execute(name, args);
    }

    @LuaMethod(name = "getTimeDelta", global = true)
    public double emitEvent() {
        return rCore.GetFrameTime();
    }

}
