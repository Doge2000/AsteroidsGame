import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

class Ship extends SpaceObject
{
    private int speed;
    private int xspeed;
    private int yspeed;
    private double angle;

    public Ship( int ex, int wy, int wd, int ht, int sp)
    {
        //write the code for the Paddle constructor
        //must have a super constructor call
        //super call must be first
        super(ex,wy,wd,ht);
        speed = sp;
        xspeed = (int) Math.cos(Math.toRadians(angle-90));
        yspeed = (int) Math.sin(Math.toRadians(angle-90));
        angle = 0;
    }
    public void rotateLeft(){
        angle -=10;
    }
    public void rotateRight(){
        angle += 10;
    }

    public void goLeftRight()
    {
        setX(getX() + xspeed); // because a paddle is a block it has the setX and getX methods

        // add the code to keep the paddle from going off the screen to the left.
    }

    public void goUpDown(){
        setY(getY()+yspeed);

    }


    public void changespeed(){
        int x = (int) Math.ceil(Math.cos(Math.toRadians(angle-90)) * 2);
        int y = (int) Math.ceil((Math.sin(Math.toRadians(angle-90)) * 2));
        xspeed+=x;
        yspeed+=y;
    }

    public void stop(){
        speed = 0;

    }

    public void keepinBounds(int w, int h){


        if(getX()>w-getW()){
            setX(w-getW());
            xspeed=xspeed*-1;

        }
        else if(getX()<0){
            setX(0);
            xspeed=xspeed*-1;

        }
        if(getY()>h-getH()){
            setY(h-getH());
            yspeed=yspeed*-1;
        }

        else if(getY()<0){
            setY(0);
            yspeed=yspeed*-1;
        }
    }


    public void paint( Graphics window )
    {

//        window.setColor(Color.BLACK);
//        window.fillRect(getX(), getY(), getW(), getH());
//        window.setColor(Color.BLACK);
//        window.drawRect(getX(), getY(), getW(), getH());


        //find and image for your paddle and put it here
        Graphics2D g2 = (Graphics2D) window;
        g2.rotate(Math.toRadians(angle), getX()+getW()/2, getY()+getH()/2);
        Image img1 = Toolkit.getDefaultToolkit().getImage("ship.gif"); //use .gif or .png, you can choose the image
        g2.drawImage(img1, getX(), getY(), getW(), getH(), this);

    }

}