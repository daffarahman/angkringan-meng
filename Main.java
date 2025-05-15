import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    private Entity player;

    public Main() {
		setFocusable(true); // Important for key events to work
		addKeyListener(this);

		// Create player entity (sprite sheet, frame size, position, scale)
		player = new Entity(SpriteLoader.loadSpriteSheet("resources/Idle.png"), 32, 32, 50, 50, 64, 64);

		setPreferredSize(new Dimension(800, 600));

        // Game loop: update every 30ms
        new Timer(30, e -> {
            player.move(1, 0); // Move right
            repaint();
        }).start();

        // Switch frame every 300ms
        new Timer(300, e -> {
            int nextFrame = (player.getX() / 32) % 10; // Just for demo
            player.setFrame(nextFrame);
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g, this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
           	System.out.println("Pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Release!");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Optional: usually not needed
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Entity Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
}
