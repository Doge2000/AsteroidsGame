import java.awt.*;

/*
 *	Directions:
 *
 *		Write the intersects method below.
 *
 *		Then move on to Block
 */
//Jade Chen
abstract class SpaceObject extends Canvas
{
    private double x, y;
    private int w, h; //these are instance variables

    public SpaceObject()
    {
        x = 0;
        y = 0;
        w = 10;
        h = 10;

    }

    public SpaceObject( int ex, int wy, int wd, int ht)
    {
        x = ex;
        y = wy;
        w = wd;
        h = ht;
    }

    // All Blocks will have all of these set and get methods
    //these methods are complete
    public double getnX( ){ return x; }
    public void setX( double ex ){ x = ex; }
    public double getnY( ){ return y; }
    public void setY( double wy ){ y = wy; }
    public int getW(){ return w; }
    public int getH(){ return h; }


    public boolean intersects( SpaceObject other)
    {

        Rectangle block = new Rectangle((int) x,(int) y,w,h);
        Rectangle otherone = new Rectangle((int) other.x, (int) other.y, other.w, other.h);
        if(block.intersects(otherone)){
            return true;
        }
        else{
            return false;
        }

        /* Hard Way:
         *		Write your own intersects logic!! Return if the two blocks are intersecting.
         */

    }
}





//    public boolean intersect(Area other){
//        Area one = new Area(other);
//        Area two = new Area(object);
//        one.intersect(two);
//        return !one.isEmpty();
//
//    }
//}