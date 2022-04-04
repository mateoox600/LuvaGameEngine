package fr.mateoox600.game;

import fr.mateoox600.game.lua.LuaManager;
import fr.mateoox600.game.raylib.RayLibManager;

import java.io.IOException;

public class Main {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    public final LuaManager luaManager;
    public final RayLibManager rayLibManager;

    public static void main(final String[] args) throws IOException {
        new Main(args);
    }

    public Main(final String[] args) throws IOException {
        instance = this;

        String mainPath = args.length > 0 ? args[0] : "./main.lua";

        this.luaManager = new LuaManager(mainPath);
        this.rayLibManager = new RayLibManager();

        rayLibManager.start();

    }

}