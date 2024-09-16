import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; //used to store array of segements of snakes body
import java.util.Random; //used to generate random x and y values to place the food 
import javax.swing.*; //used to create the game window

public class SnakeGame extends JPanel implements ActionListener, KeyListener{  //keylistener--> to be able to control snake using arrow keys
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

    //snake
    Tile snakeHead;
    ArrayList<Tile> snakeBody;

    //food
    Tile food;
    Random random; //to generate random locations for the food to be placed

    //game logic
    //redraw the panel with updated values of x and y
    Timer gameLoop;
    int velocityX; //to make the snake move, we need velocity. positive-->right, negative-->left
    int velocityY;


    SnakeGame(int boardWidth, int boardHeight){
        //constructor to initialize the board width and height
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));

        //set color of the window
        setBackground(Color.black);

        //make panel listen to the keyListeners
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5, 5); 
        food=new Tile(10,10);
        random= new Random();

        placeFood(); //call function

        velocityX=0;
        velocityY=0; 

        gameLoop=new Timer(100, this); //100ms=1/10 of a sec
        gameLoop.start(); //start the game loop

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g); 
    }
    //draw object defined
    public void draw(Graphics g){
        //draw grid lines
        for(int i=0;i<boardWidth/tileSize;i++){
            g.drawLine(i*tileSize, 0, i*tileSize, boardHeight); //vertical lines
            g.drawLine(0, i*tileSize, boardWidth, i*tileSize); //horizontal lines
        }

        //draw food
        g.setColor(Color.red);
        g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);

        //draw the snake head
        g.setColor(Color.green);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y *tileSize, tileSize, tileSize); 
    }

    public void placeFood(){
        //this function will randomly set x and y coordinates of the food
        food.x=random.nextInt(boardWidth/tileSize);//600/25=24, 0-24 random
        food.y=random.nextInt(boardHeight/tileSize);
    }

    public void move(){
        //snake head
        snakeHead.x += velocityX;
        snakeHead.y +=velocityY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move(); //will update x and y position of the sanke
        repaint(); //will call draw over and over again
    }

    //method that need to be overided to implement KeyListener
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP && velocityY !=1){ // to avoid snake to touch its body and terminate the game
            velocityX=0;
            velocityY=-1;
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityY!=-1){
            velocityX=0;
            velocityY=1;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT && velocityX!=1){
            velocityX=-1;
            velocityY=0;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX!=-1){
            velocityX=1;
            velocityY=0;
        }
    }

    //rest we do not need
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
