
package mytetris;

import javax.swing.JFrame;


public class Window {
    private JFrame window;
    public static final int WIDTH =300, HEIGHT=600;
    private Board board; 
    
    public Window(){
        window = new JFrame("Tetris !!!");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null); //centered window
        
        board = new Board();
        window.add(board);
        
        window.setVisible(true);
    }
    
    public static void main(String[] args){
        new Window(); 
    }
    
}
