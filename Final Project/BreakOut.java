/*
 * Nicholas Colonna & Evan Gutch 
 * Group 12
 * Assignment 8 Project
 * Break Out / Brick Breaker Game
 * CS 501WS
*/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class BreakOut extends GraphicsProgram
{
    public static final int WIDTH = 350;	//width of screen
    public static final int HEIGHT = 470;	//height of screen
    public static final int BOTTOM = HEIGHT - 30;	//bottom of play area
    public static final int P_RIGHT = 288;	//limit to how far paddle can go right
    
    private GOval ball;		//ball object
    private GRect paddle;	//paddle object
    private GRect brick;	//brick objects
    int r = 5;				//radius of the ball
    private double dirX;		//direction of ball in x axis
    private double dirY;		//direction of ball in y axis
    private double locX;		//location of ball in x axis
    double p_loc;
    int p_move;					//used for paddle movement size
    int score = 0;			//keep track of the score from hitting bricks
    int loseCount = 0;		//keep track of how many times the ball has fallen below the paddle
    GLabel scoreLabel = new GLabel("Score: " + score, 235,30);
    
    //sets window size and begins game
    public static void main(String[] args)
    {
        String[] sizeArgs = { "width=" + WIDTH, "height=" + HEIGHT };
        new BreakOut().start(sizeArgs);
    }

    //calls functions to setup the game and start when the user is read
    public void run(){
        setup();	//essentially gets the whole game ready to go
        waitForClick();		//waits for the user to manually begin playing
        play();		//starts the game
    }  
    
    //sets up the game before playing
    public void setup(){ 
        create_paddle();		//create the paddle
        create_ball();			//create the ball  
        create_bricks();		//create the bricks
        addKeyListeners();
        setFocusable(true);
        add(scoreLabel);		//adds score label to top of game screen
        scoreLabel.setFont(new Font("Comic Sans",Font.BOLD,22));      
    } 
    
    //creates the paddle at the bottom center of screen
    public void create_paddle(){
        paddle = new GRect(145, BOTTOM-10, 60, 9);		//create rectangle object to be paddle
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);	//make paddle black
        add(paddle);
    }
    
    //creates the ball right above the paddle
    public void create_ball(){
        ball = new GOval(171, (BOTTOM-20), 10, 10);		//create oval object to be the ball
        ball.setFilled(true);
        ball.setFillColor(Color.BLUE);		//make ball blue
        add(ball);
    }
    
    //creates the bricks at the top of the screen (6 rows and 6 columns)
    public void create_bricks(){
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                brick = new GRect((x*54+15), (y*22+35), 50, 14);	//create rectangle object for a brick
                brick.setFilled(true);
                
                //set color of bricks based on which row we are in
                if(y == 0){
                  brick.setFillColor(Color.RED);
                }
                else if(y == 1){
                  brick.setFillColor(Color.ORANGE);
                }
                else if(y == 2){
                  brick.setFillColor(Color.GREEN);
                }
                else if(y == 3){
                  brick.setFillColor(Color.CYAN);
                }
                else if(y == 4){
                  brick.setFillColor(Color.YELLOW);
                }
                else if(y == 5){
                  brick.setFillColor(Color.MAGENTA);
                }
       
                add(brick);
            }
        }
    }
    
    //called after user makes first click. Begins the functions that control gameplay
    public void play(){
        startBall();	//start ball movement
        playGame();		//starts all other necessary functions (score, win/lose, etc.)
    }
    
    //starts the ball off in a random direction
    public void startBall(){
        RandomGenerator random = new RandomGenerator();
        dirX = random.nextDouble(1.0, 3.25);	//generate randomness to steepness of ball flight
        if(random.nextBoolean(0.5)){	//generate boolean, if true start left, false start right
            dirX = -dirX;
        }
        dirY = -4.0;
    }
    
    //plays the game until the user wins or loses
    public void playGame(){
        while(true){
            score();	//start keeping score
           
            if(score < 360){		//if user doesn't have max score yet, bricks still remain. Keep playing
                ball.move(dirX,dirY);
                pause(15);
            
                //if ball hits left wall, reverse x direction
                if(ball.getX() <= 0){
                    dirX = -dirX;
                }
                //if ball hits right wall reverse x direction
                if(ball.getX() >= WIDTH-10){
                    dirX = -dirX;
                }
                //if ball hits top wall reverse y direction
                if(ball.getY() <= 0){
                    dirY = -dirY;
                }
            
                //if ball falls below bottom of screen, loser
                if(ball.getY() >= HEIGHT){
                    loseCount += 1;
                    if(loseCount < 2){		//if first time loser, reset paddle and ball then play again
                        remove(ball);	
                        remove(paddle);	
                        create_paddle();	
                        create_ball();
                        waitForClick();
                        play();
                    }
                    else{		//if loser twice, game over. Print message to user
                        GLabel lose = new GLabel("", 83, 225);
                        lose.setFont(new Font("Comic Sans",Font.BOLD,28));
                        lose.setLabel("GAME OVER!");
                        add(lose);
                        remove(ball);
                        waitForClick();
                    }
                }
            
            
                //checks for a collision with a brick or paddle
                GObject collide = collidingObject();
            
                if(collide == paddle){		//if it collided with the paddle
                    if((locX < paddle.getX() + paddle.getWidth()/4) && dirX > 0) {		//if hit on left quarter and ball heading right
                    	dirX = -dirX;  //flip x direction
                    }else if((locX > paddle.getX() + 3*paddle.getWidth()/4) && dirX < 0) {	//if hit on right quarter and ball heading left
                    	dirX = -dirX;	//flip x direction
                    }
                	dirY = -dirY;	//change y direction
                }
                else if(collide instanceof GRect){		//if collided with one of the bricks
                    dirY = -dirY;	//change y direction
                    remove(collide);	//remove the brick that was hit
                    score = score + 10;		//increment the score
                }
            }
        }
    }
    
    //keeps track of the score throughout the game. If all bricks are hit, winner message is displayed
    public void score(){
        scoreLabel.setLabel("Score: " + score);
        
        //displays winner message if player hits all of the blocks
        if(score == 360){
            GLabel win = new GLabel("", 110, 225);
            win.setFont(new Font("Comic Sans", Font.BOLD, 28));
            win.setLabel("WINNER!");
            add(win);
            remove(ball);
        }
    }
    
    //this function checks if the ball has collided with an object (on any of its sides)
    //it returns the object that was collided with, null otherwise
    private GObject collidingObject(){
        if(getElementAt(ball.getX(), ball.getY()) !=null){
        	locX = ball.getX();
            return getElementAt(ball.getX(), ball.getY());
        }
        else if(getElementAt(ball.getX()+r*2, ball.getY()) !=null){
        	locX = ball.getX() + r*2;
            return getElementAt(ball.getX()+r*2, ball.getY());
        }
        else if(getElementAt(ball.getX()+r*2, ball.getY()+r*2) !=null){
        	locX = ball.getX() + r*2;
            return getElementAt(ball.getX()+r*2, ball.getY()+r*2);
        }
        else if(getElementAt(ball.getX(), ball.getY()+r*2) !=null){
        	locX = ball.getX();
            return getElementAt(ball.getX(), ball.getY()+r*2);
        }
        else{
            return null;
        }
    }

    //detects the pressing of the left and right arrow keys to move the paddle
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        p_loc = paddle.getX() + p_move;

        if (key == KeyEvent.VK_LEFT) {	 //if left arrow pressed, move paddle left
            p_move = -10;
            if (p_loc <= 2) {			//if paddle on left wall, don't move
                paddle.move(0,0);
            }
            else{
                paddle.move(p_move,0);
            }
        }

        if (key == KeyEvent.VK_RIGHT) {		//if right arrow pressed, move paddle right
            p_move = 10;
            if (p_loc <= P_RIGHT) {		//if paddle on right wall, don't move
                paddle.move(p_move,0);
            }
            else{
                paddle.move(0,0);
            }
        }
    }
    
}
