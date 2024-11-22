import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions:
 *
 *		Write the intersects method below.
 *
 *		Then move on to Block
 */
//Jade Chen
abstract class Block extends Canvas
{
	private int x, y, w, h; //these are instance variables

	public Block()
	{
		x = 0;
		y = 0;
		w = 10;
		h = 10;

	}
	
	public Block( int ex, int wy, int wd, int ht)
	{
		x = ex;
		y = wy;
		w = wd;
		h = ht;
	}
	
	// All Blocks will have all of these set and get methods
	//these methods are complete
	public int getX( ){ return x; }
	public void setX( int ex ){ x = ex; }
	public int getY( ){ return y; }
	public void setY( int wy ){ y = wy; }
	public int getW(){ return w; }
	public int getH(){ return h; }
	
	
	public boolean intersects( Block other )
	{
		/* Easy Way:
		 * 		Copy and Paste the following URL in google chrome
		 *		https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
		 *		make new Rectangle, using this Block's x,y,w,h
		 *		make new Rectangle, using the other Block's x,y,w,h
		 *		return if the two rectangles intersect, use the Rectangle's intersects method.
		 */
		Rectangle block = new Rectangle(x,y,w,h);
		Rectangle otherone = new Rectangle(other.x, other.y, other.w, other.h);
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