import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;

class Ship extends SpaceObject
{
    private double speed;
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
        xspeed = 0;
        yspeed = 0;
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

    public double getXspeed() {
        return xspeed;
    }

    public double getYspeed() {
        return yspeed;
    }
    public double getSpeed(){
        return Math.sqrt(Math.pow(xspeed,2)+Math.pow(yspeed,2));
    }

    public void changespeed(){

            double x = Math.cos(Math.toRadians(angle - 90)) * 0.25;
            double y = Math.sin(Math.toRadians(angle - 90)) * 0.25;
            xspeed += x;
            yspeed += y;
            speed = Math.sqrt(Math.pow(xspeed, 2) + Math.pow(yspeed,2));



    }

    public void dampener(){
       if(xspeed>0){
           xspeed/=1.1;
       }
       else if(xspeed<0){
           xspeed/=1.1;
       }
       else{
           xspeed=0;
       }
       if(yspeed<0){
           yspeed/=1.1;
       }
       else if(yspeed>0){
           yspeed/=1.1;
       }
       else{
           yspeed=0;
       }
    }

    public void stop(){
        xspeed = 0;
        yspeed = 0;
    }

    public void keepinBounds(int w, int h){


        if(getnX()>w){
            setX(-getW());


        }
        else if(getnX()<-getW()){
            setX(w);


        }
        if(getnY()>h){
            setY(-getH());

        }

        else if(getnY()<-getH()){
            setY(h);

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