import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SpriteLoader {
	public static BufferedImage loadSpriteSheet(String filePath) {
		BufferedImage spriteSheet = null;
		try {
            spriteSheet = ImageIO.read(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spriteSheet;
	}
}
