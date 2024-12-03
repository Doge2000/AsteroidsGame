import java.awt.*;
import java.awt.geom.Area;

abstract class SpaceObject {
    private int x,y;
    private Polygon object;
    public SpaceObject(){
        x=0;
        y=0;

    }
    public SpaceObject(int ex, int wy){
        x = ex;
        y = wy;

    }
    public void SetPolygon(Polygon obj){
        object = obj;
    }
    public void getPolygon(){
        return object;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

   public boolean intersects(SpaceObject other){
       Area one = new Area(other.getPolygon());
        Area two = new Area(object);
       one.intersects(two);
        return !one.isEmpty();

   }
}
