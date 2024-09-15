import javax.swing.*; //swing lib is imported to create interface

public class App {
    public static void main(String[] args) throws Exception {
        //setting the size of the pop-up window in px
        int boardWidth=700;
        int boardHeight=boardWidth;

        //creating window
        JFrame frame=new JFrame("Snake Game");
        frame.setVisible(true); //visibility of window is set to true
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null); //will open the window in the center of the screen
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the prog will terminate once the user exits the window

        //creating an instance
        SnakeGame snakeGame=new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);
        frame.pack(); //.stack()-->a Window class in Java and it sizes the frame so that all its contents are at or above their preferred sizes
        
    }
}
