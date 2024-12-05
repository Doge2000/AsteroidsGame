import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

class Ship extends SpaceObject
{
    private int speed;
    private double xspeed;
    private double yspeed;
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
        setX(getnX() + xspeed); // because a paddle is a block it has the setX and getX methods

        // add the code to keep the paddle from going off the screen to the left.
    }

    public void goUpDown(){
        setY(getnY()+yspeed);

    }


    public void changespeed(){
        double x =  Math.cos(Math.toRadians(angle-90));
        double y =  Math.sin(Math.toRadians(angle-90));
        xspeed+=x;
        yspeed+=y;
    }

    public void stop(){
        speed = 0;

    }

    public void keepinBounds(int w, int h){


        if(getnX()>w-getW()){
            setX(w-getW());
            xspeed=xspeed*-1;

        }
        else if(getnX()<0){
            setX(0);
            xspeed=xspeed*-1;

        }
        if(getnY()>h-getH()){
            setY(h-getH());
            yspeed=yspeed*-1;
        }

        else if(getnY()<0){
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
        g2.rotate(Math.toRadians(angle), getnX()+getW()/2, getnY()+getH()/2);
        Image img1 = Toolkit.getDefaultToolkit().getImage("ship.gif"); //use .gif or .png, you can choose the image
        g2.drawImage(img1, (int) getnX(), (int) getnY(), getW(), getH(), this);

    }

}