package mytetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

    private BufferedImage blocks;
    private final int blockSize = 30;
    private final int boardWidth = 10;
    private final int boardHeight = 20;

    private int[][] board = new int[boardWidth][boardHeight];

    public Board() {
        try {
            blocks = ImageIO.read(Board.class.getResource("/mytetris/Textures/tiles.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //call parent JPanel's implementation of the method paintComponent on g

        for (int i = 0; i < boardHeight; i++) {
            //horizontal lines
            g.drawLine(0, i * blockSize, boardWidth * blockSize, i * blockSize);
        }

        for (int i = 0; i < boardWidth; i++) {
            //vertical lines
            g.drawLine(i * blockSize, 0, i * blockSize, boardHeight * blockSize);
        }
    }
}
