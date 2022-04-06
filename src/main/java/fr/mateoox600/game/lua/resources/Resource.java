package fr.mateoox600.game.lua.resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Resource {

    private Path path;

    public Resource(String path) {
        this.path = Path.of(path);
    }

    public Resource(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path.normalize().toAbsolutePath();
    }

    public void setPath(String path) {
        this.path = Path.of(path).normalize().toAbsolutePath();
    }

    public FileReader toFileReader() throws FileNotFoundException {
        return new FileReader(path.toFile());
    }

    public boolean isDirectory() {
        return Files.isDirectory(path);
    }

    public boolean fileExist() {
        return Files.exists(path);
    }
}
