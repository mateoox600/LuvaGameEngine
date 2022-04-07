package fr.mateoox600.game.lua.resources;

import fr.mateoox600.game.Main;
import se.krka.kahlua.integration.LuaReturn;
import se.krka.kahlua.luaj.compiler.LuaCompiler;
import se.krka.kahlua.vm.LuaClosure;

import java.io.IOException;
import java.io.InputStream;

public class LuaFileUtils {

    private static final Main main = Main.getInstance();

    public static LuaClosure loadLuaFile(String path) throws IOException {
        LuaClosure closure = null;

        if(path.startsWith("<") && path.endsWith(">")) {
            InputStream inputStream = ResourceLoader.loadStdLua(path);

            if(inputStream == null) throw new IOException("STD FILE '" + path.substring(1, path.length() - 1) + "' NOT FOUND");

            closure = LuaCompiler.loadis(inputStream, path, main.luaManager.env);
        }else if(path.startsWith("./") || path.startsWith("../")) {
            Resource file = ResourceLoader.loadLuaFile(path);

            closure = LuaCompiler.loadis(file.toFileReader(), file.getPath().toString(), main.luaManager.env);
        }

        return closure;
    }

    public static LuaReturn executeLuaClosure(LuaClosure closure, Object ...args) {
        LuaReturn returns = main.luaManager.caller.protectedCall(main.luaManager.thread, closure, args);
        if(!returns.isSuccess()) System.out.println(returns.getErrorString() + " " + returns.getLuaStackTrace());
        return returns;
    }

    public static LuaReturn executeLuaFile(String path, Object ...args) throws IOException {
        LuaClosure closure = loadLuaFile(path);
        if(closure == null) throw new IOException("LUA FILE '" + path + "' NOT FOUND");
        LuaReturn returns = main.luaManager.caller.protectedCall(main.luaManager.thread, closure, args);
        if(!returns.isSuccess()) System.out.println(returns.getErrorString() + " " + returns.getLuaStackTrace());
        return returns;
    }

}
