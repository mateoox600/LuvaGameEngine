package fr.mateoox600.game.raylib;

import com.raylib.java.textures.Texture2D;
import fr.mateoox600.game.Main;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {

    private static final Main main = Main.getInstance();

    public static final List<Texture2D> loadedTextures = new ArrayList<>();

    public static void free() {
        loadedTextures.forEach((texture) -> main.rayLibManager.raylib.textures.UnloadTexture(texture));
    }

}
