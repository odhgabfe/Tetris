package mytetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Shape {

    private BufferedImage block;
    private int[][] coords;
    private Board board;

    public Shape(BufferedImage block, int[][] coords, Board board) {
        this.block = block;
        this.board = board;
        this.coords = coords;
    }
    
    public void update(){
        
    }
    
    public void render(Graphics g){
        for (int row =0; row < coords.length; row++){
            for (int col = 0; col < coords[row].length; col++){
                if (coords[row][col] != 0){
                    g.drawImage(block, col*30, row*30, null);
                }
            }
        }
        
    }
}
