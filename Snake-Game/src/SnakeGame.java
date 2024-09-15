import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; //used to store array of segements of snakes body
import java.util.Random; //used to generate random x and y values to place the food 
import javax.swing.*; //used to create the game window

public class SnakeGame extends JPanel{
    //created a class SnakeGame which wil inherit the properties of JPanel
    //version of JPanel where we can add more attributes

    private class Tile{ //can only be accessed by the SnakeGame
        int x, y;

        Tile(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    int boardWidth;
    int boardHeight;
    int tileSize=25;

    Tile snakeHead;

    SnakeGame(int boardWidth, int boardHeight){
        //constructor to initialize the board width and height
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));

        //set color of the window
        setBackground(Color.black);

        snakeHead = new Tile(5, 5);

    }
}
