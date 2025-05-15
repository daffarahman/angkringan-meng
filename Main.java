import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    private Entity player;
    private boolean up, down, left, right;

    public Main() {
		setFocusable(true); // Important for key events to work
		addKeyListener(this);

		// Create player entity (sprite sheet, frame size, position, scale)
		player = new Entity(SpriteLoader.loadSpriteSheet("resources/Idle.png"), 32, 32, 50, 50, 64, 64);

		setPreferredSize(new Dimension(800, 600));

        // Game loop: update every 30ms
        new Timer(30, e -> {
        	int speed = 3;
		    if (up)    player.move(0, -speed);
		    if (down)  player.move(0, speed);
		    if (left)  player.move(-speed, 0);
		    if (right) player.move(speed, 0);
            repaint();
        }).start();

        // Switch frame every 300ms
        new Timer(100, e -> {
            int nextFrame = (player.getX() / 32) % 10; // Just for demo
            player.setFrame(nextFrame);
            repaint();
        }).start();

        

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g, this);
    }

    @Override
	public void keyPressed(KeyEvent e) {
	    switch (e.getKeyCode()) {
	        case KeyEvent.VK_W, KeyEvent.VK_UP -> up = true;
	        case KeyEvent.VK_S, KeyEvent.VK_DOWN -> down = true;
	        case KeyEvent.VK_A, KeyEvent.VK_LEFT -> left = true;
	        case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> right = true;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
	    switch (e.getKeyCode()) {
	        case KeyEvent.VK_W, KeyEvent.VK_UP -> up = false;
	        case KeyEvent.VK_S, KeyEvent.VK_DOWN -> down = false;
	        case KeyEvent.VK_A, KeyEvent.VK_LEFT -> left = false;
	        case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> right = false;
	    }
	}


    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Angkringan Si Meng");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
}
