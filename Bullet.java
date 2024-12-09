import java.awt.*;

class Bullet extends SpaceObject{
//    private double speed;
    private double xspeed;
    private double yspeed;






    public Bullet( int ex, int wy, double xsp, double ysp)
    {
        super(ex,wy,5,5);
//        speed = xsp;

        xspeed = xsp;
        yspeed = ysp;


    }
    public void shoot(Ship ship, Graphics window){
        double x = Math.cos(Math.toRadians(ship.getAngle())) * 0.25;
        double y = Math.sin(Math.toRadians(ship.getAngle())) * 0.25;
        xspeed = x+5;
        yspeed = y+5;
        this.paint(window);



    }
    public void goLeftRight()
    {
        setX(getnX() + xspeed);
    }

    public void goUpDown(){
        setY(getnY()+yspeed);

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
    public void paint(Graphics window){
        window.setColor(Color.white);
        window.fillRect((int) getnX(), (int) getnY(), getW(), getH());
        window.setColor(Color.BLACK);
        window.drawRect((int) getnX(), (int) getnY(), getW(), getH());
    }
}
