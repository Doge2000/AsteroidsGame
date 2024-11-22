import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions:
 *              Make sure you have completed Block first.
 *
 *				Make the brick extend Block
 *
 *				Write the Brick constructor that takes an x, y, w, h to create a block.
 *
 *				Override the paint method to draw a Brick

				Choose to draw or import an image.
 *
 *				use the ClassTester to make sure your Brick works.
 */
//Jade Chen

class Brick extends Block
{

    public Brick( int ex, int wy, int wd, int ht)
    {
        super(ex, wy, wd, ht);


    }

    //overidde paint to draw your Paddle
    public void paint( Graphics window )
    {
        //window.drawString("Brick Class ", 50, 150 );

        // drawing methods for Java:
        // go to the Graphics Intro Folder
        window.setColor(Color.RED);
		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());


        //find and image for your paddle and put it here
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("brick.png"); //use .gif or .png, you can choose the image
        g2.drawImage(img1, getX(), getY(), getW(), getH(), this);

    }

}