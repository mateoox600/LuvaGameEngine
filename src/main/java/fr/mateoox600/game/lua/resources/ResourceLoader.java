package fr.mateoox600.game.lua.resources;

import java.io.InputStream;

public class ResourceLoader {

    public static Resource loadResource(String relativePath) {
        return new Resource(relativePath);
    }

    public static InputStream loadJarResourceAsStream(String path) {
        return ResourceLoader.class.getResourceAsStream(path);
    }

    public static InputStream loadStdLua(String path) {
        return loadJarResourceAsStream("/std/" + path.substring(1, path.length() - 1));
    }

    public static Resource loadLuaFile(String relativePath) {
        Resource resource = ResourceLoader.loadResource(relativePath);

        if(resource.isDirectory()) resource.setPath(resource.getPath() + "/main.lua");

        return resource;
    }

}
