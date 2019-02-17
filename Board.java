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
    private Shape[] shapes = new Shape[7];
    private Shape currentShape;

    private int[][] board = new int[boardWidth][boardHeight];

    public Board() {
        try {
            blocks = ImageIO.read(Board.class.getResource("/mytetris/Textures/tiles.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //SHAPES
        shapes[0] = new Shape(
                blocks.getSubimage(0, 0, blockSize, blockSize), //arg1
                new int[][]{
                    {1, 1, 1, 1} //XXXX I-shaped block
                }, //arg2
                this);                                          //arg3

        shapes[1] = new Shape(
                blocks.getSubimage(blockSize, 0, blockSize, blockSize), //arg1
                new int[][]{
                    {1, 1, 0},
                    {0, 1, 1} //Z-shaped block look at the 1's as lit pixels
                }, //arg2
                this);                                          //arg3

        shapes[2] = new Shape(
                blocks.getSubimage(blockSize*2, 0, blockSize, blockSize), //arg1
                new int[][]{
                    {0, 1, 1},
                    {1, 1, 0} //S-shaped block
                }, //arg2
                this);                                          //arg3
        
     

        shapes[3] = new Shape(
                blocks.getSubimage(blockSize*3, 0, blockSize, blockSize), //arg1
                new int[][]{
                    {1, 1, 1},
                    {0, 0, 1} //J-shaped block
                }, //arg2
                this);                                          //arg3
        
        shapes[4] = new Shape(
                blocks.getSubimage(blockSize*4, 0, blockSize, blockSize), //arg1
                new int[][]{
                    {1, 1, 1},
                    {1, 0, 0} //L-shaped block
                }, //arg2
                this);                                          //arg3
        
        shapes[5] = new Shape(
                blocks.getSubimage(blockSize*5, 0, blockSize, blockSize), //arg1
                new int[][]{
                    {1, 1, 1},
                    {0, 1, 0} //T-shaped block
                }, //arg2
                this);                                          //arg3
        
        shapes[6] = new Shape(
                blocks.getSubimage(blockSize*6, 0, blockSize, blockSize), //arg1
                new int[][]{
                    {1, 1},
                    {1, 1} //0-shaped block
                }, //arg2
                this);                                          //arg3
        
        currentShape = shapes[5];
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
        
        currentShape.render(g);
    }
}
