package fr.mateoox600.game.lua;

import fr.mateoox600.game.lua.resources.ResourceLoader;
import se.krka.kahlua.j2se.KahluaTableImpl;
import se.krka.kahlua.j2se.MathLib;
import se.krka.kahlua.luaj.compiler.LuaCompiler;
import se.krka.kahlua.stdlib.*;
import se.krka.kahlua.test.UserdataArray;
import se.krka.kahlua.threading.BlockingKahluaThread;
import se.krka.kahlua.vm.*;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class LuaPlatform implements Platform {

    private static final LuaPlatform INSTANCE = new LuaPlatform();
    public static LuaPlatform getInstance() {
        return INSTANCE;
    }

    public double pow(double x, double y) {
        return Math.pow(x, y);
    }

    public KahluaTable newTable() {
        return new KahluaTableImpl(new ConcurrentHashMap<>());
    }

    public KahluaTable newEnvironment() {
        KahluaTable env = this.newTable();
        this.setupEnvironment(env);
        return env;
    }

    public void setupEnvironment(KahluaTable env) {
        env.wipe();
        env.rawset("_G", env);
        env.rawset("_VERSION", "Kahlua 2.1.0 for Lua 5.1 (J2SE)");
        MathLib.register(this, env);
        BaseLib.register(env);
        RandomLib.register(this, env);
        UserdataArray.register(this, env);
        StringLib.register(this, env);
        CoroutineLib.register(this, env);
        OsLib.register(this, env);
        TableLib.register(this, env);
        LuaCompiler.register(env);
        KahluaThread workerThread = this.setupWorkerThread(env);
        KahluaUtil.setupLibrary(env, workerThread, "/stdlib");

        try {
            LuaClosure closure = LuaCompiler.loadis(ResourceLoader.loadJarResourceAsStream("/serialize.lua"), "serialize.lua", env);
            workerThread.call(closure, null, null, null);
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    private KahluaThread setupWorkerThread(KahluaTable env) {
        BlockingKahluaThread thread = new BlockingKahluaThread(this, env);
        KahluaUtil.setWorkerThread(env, thread);
        return thread;
    }
}
