import java.awt.*;

class Ship extends SpaceObject{
    private int xspeed;
    private int yspeed;
    private int angle;
    private int x1 =200;
    private int x2 = 210;
    private int x3 = 205;
    private int y1 = 30;
    private int y2 = 30;
    private int y3 = 40;
    Polygon object;

    public Ship(){
        super(0,0);
        xspeed = 0;
        yspeed = 0;
        angle = 0;
        int x[] = {x1, x2, x3};
        int y[] = {y1, y2, y3};
        object = new Polygon(x, y, 3);

    }
    public int getX1(){
        return x1;
    }
    public int getX2(){
        return x2;
    }
    public int getX3(){
        return x3;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public int getY3() {
        return y3;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public void paint(Graphics window){
        window.setColor(Color.WHITE);
        window.fillPolygon(object);
    }
    public void move(){
        setX1(getX1() + xspeed);
        setX2(getX2() + xspeed);
        setX3(getX3() + xspeed);
        setY1(getY1() + xspeed);
        setY2(getY2() + xspeed);
        setY3(getY3() + xspeed);
    }
    public void addSpeed(){
        xspeed+=Math.COS(angle)*10;
        yspeed+=Math.SIN(angle)*10;
    }
    public int getXspeed(){
        return xspeed;
    }
    public int getYspeed(){
        return yspeed;
    }
}
