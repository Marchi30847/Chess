import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AssetManager {
    static AssetManager assetManager = new AssetManager();

    private final Map<String, Image> textures;

    private AssetManager() {
        textures = new HashMap<>();
    }
    public Image getTexture(String path) {
        if (!textures.containsKey(path)) {
            try {
                ImageIcon icon = new ImageIcon(path);
                textures.put(path, icon.getImage());
            } catch (Exception e) {
                System.err.println("Error loading texture, file is not found " + path);
                e.printStackTrace();
            }
        }
        return textures.get(path);
    }
}
