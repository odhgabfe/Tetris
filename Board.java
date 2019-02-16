package mytetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

    private BufferedImage blocks;

    public Board() {
        try {
            blocks = ImageIO.read(Board.class.getResource("/mytetris/Textures/tiles.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //call parent JPanel's implementation of the method paintComponent on g
        g.draw3DRect(100, 100, 50, 50, true);
        
        g.drawImage(blocks, 0, 0, null);
    }
}
