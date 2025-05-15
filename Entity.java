import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    private BufferedImage spriteSheet;
    private int spriteWidth, spriteHeight;
    private int currentFrame;
    private int x, y;
    private int scaleWidth, scaleHeight;

    public Entity(BufferedImage spriteSheet, int spriteWidth, int spriteHeight, int x, int y, int scaleWidth, int scaleHeight) {
        this.spriteSheet = spriteSheet;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.currentFrame = 0;
        this.x = x;
        this.y = y;
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
    }

    // Move the entity
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Set position
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Set scale
    public void setScale(int width, int height) {
        this.scaleWidth = width;
        this.scaleHeight = height;
    }

    // Set current frame
    public void setFrame(int frame) {
        this.currentFrame = frame;
    }

    // Draw the entity on screen
    public void draw(Graphics g, Component observer) {
        int spriteX = currentFrame * spriteWidth;
        int spriteY = 0; // 1 row sprite sheet
        BufferedImage frame = spriteSheet.getSubimage(spriteX, spriteY, spriteWidth, spriteHeight);
        Image scaled = frame.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
        g.drawImage(scaled, x, y, observer);
    }

    // Getters for x/y (optional)
    public int getX() { return x; }
    public int getY() { return y; }
}
