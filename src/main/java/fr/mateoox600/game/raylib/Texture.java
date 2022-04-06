package fr.mateoox600.game.raylib;

import com.raylib.java.textures.Image;
import com.raylib.java.textures.Texture2D;
import com.raylib.java.textures.rTextures;
import fr.mateoox600.game.Main;

public class Texture {

    private final Main main = Main.getInstance();

    public final Image image;
    public final Texture2D texture;

    public Texture(Image image) {
        this.image = image;
        this.texture = rTextures.LoadTextureFromImage(image);
    }

    public void free() {
        rTextures.UnloadImage(this.image);
        main.rayLibManager.raylib.textures.UnloadTexture(this.texture);
    }

}
