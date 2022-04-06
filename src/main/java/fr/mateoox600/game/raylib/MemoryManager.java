package fr.mateoox600.game.raylib;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {

    public static final List<Texture> loadedTextures = new ArrayList<>();

    public static void free() {
        loadedTextures.forEach(Texture::free);
    }

}
