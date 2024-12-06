import java.awt.*;

class Bullet extends SpaceObject{
    private double speed;
    private double xspeed;
    private double yspeed;






    public Bullet( int ex, int wy, int sp)
    {
        super(ex,wy,4,4);
        speed = sp;
        xspeed = 0;
        yspeed = 0;


    }
//    public void shoot(Ship ship, Graphics window){
//        double x = Math.cos(Math.toRadians(ship.getAngle() - 90)) * 0.25;
//        double y = Math.sin(Math.toRadians(ship.getAngle() - 90)) * 0.25;
//        xspeed = x+5;
//        yspeed = y+5;
//        this.setX(ship.getnX()-10);
//        this.setY(ship.getnY()-10);
//        speed = Math.sqrt(Math.pow(xspeed, 2) + Math.pow(yspeed,2));
//
//
//    }
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
