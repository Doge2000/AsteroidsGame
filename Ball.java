import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions: extend the Block class to use the Block methods
 *
 *				Override the paint method to draw a Ball
 *				
 *				Make an xspeed and a yspeed instance variable in order to make the ball bounce
 *				
 *				Create a Ball constructor, using the Paddle constructor as an example, it can still take
 *				in just one speed, then set both instance variables to that one speed.
 *				
 *				Create a bounce method that keeps the ball on the screen but bounces around the screen.
 *				Do NOT test if the ball is touching the bricks or the paddle in this method, you will do that
 *				in the game logic in BreakOut.java.
 *
 *				Go to BreakOut and do Step 2 and test it in the runner.
 *
 *				If all works then move on to Brick
 *				
 */
//Jade Chen

class Ball extends Block
{
    private int xspeed;
    private int yspeed;
    public Ball( int ex, int wy, int wd, int ht, int xsp, int ysp)
    {
        super(ex, wy, wd, ht);
        xspeed = xsp;
        yspeed = ysp;


    }
    public void moveRightLeft(){
        setX(getX() + xspeed);


    }
    public void moveUpDown(){
        setY(getY()+yspeed);
    }
    public void stop(){
        xspeed = 0;
        yspeed = 0;
    }
    public void keepinBounds(){


        if(getX()>800-getW()){
            setX(800-getW());
            xspeed=xspeed*-1;

        }
        else if(getX()<0){
            setX(0);
            xspeed=xspeed*-1;

        }
        if(getY()>600-getH()){
            setY(600-getH());
            yspeed=yspeed*-1;
        }

        else if(getY()<0){
            setY(0);
            yspeed=yspeed*-1;
        }
    }
    public int getXspeed(){
        return xspeed;
     }
     public int getYspeed(){
        return yspeed;
     }
    public void changeSpeed(){
        yspeed = yspeed*-1;

    }
    public void paint(Graphics window){
        window.setColor(Color.GREEN);
        window.fillRect(getX(), getY(), getW(), getH());
        window.setColor(Color.BLACK);
        window.drawRect(getX(), getY(), getW(), getH());
    }

	
	

}