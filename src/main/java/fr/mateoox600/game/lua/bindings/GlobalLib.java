package fr.mateoox600.game.lua.bindings;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalLib {

    private final Main main = Main.getInstance();

    @LuaMethod(name = "require", global = true)
    public Object require(String file) throws IOException {
        Pattern fileExtRegexPattern = Pattern.compile("\\.(\\w+$)");
        Matcher matcher = fileExtRegexPattern.matcher(file);
        if(!matcher.find() || matcher.group(1).equals("lua")) {
            LuaReturn end = LuaFileUtils.executeLuaFile(file);
            return end.getFirst();
        }
        return null;
    }

    @LuaMethod(name = "load", global = true)
    public Texture load(String path) {
        Image image = rTextures.LoadImage(ResourceLoader.loadResource(path).getPath().toString());
        Texture texture = new Texture(image);
        MemoryManager.loadedTextures.add(texture);
        return texture;
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

}
