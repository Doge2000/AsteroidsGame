import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class game extends JPanel implements Runnable, KeyListener
{
    //Jade Chen

    private boolean[] keys; // this stores booleans for when a key is pressed or not.

    //PROCESS EACH ONE OF THESE ONE AT A TIME
    private Ship testship;



    public game() // create all instance in here
    {
        int x=0;
        int y=0;
        int w=0;
        int h=0;
        setBackground(Color.WHITE);

        testship = new Ship();

        //make the keys array big enough to store all keys pressed
        keys = new boolean[3];		// scroll down to see the keyPressed method



        addKeyListener( this );   	//
        setFocusable( true );		// Do NOT DELETE these three lines
        new Thread(this).start();	//
    }

    public void paint( Graphics window )// all other paint methods and game logic goes in here.
    {
        window.setColor(Color.BLACK); window.fillRect( 0,0, getWidth(), getHeight()); // makes the background white
        window.setColor(Color.BLACK); window.drawRect( 0,0, getWidth(), getHeight()); // draws a black box around the outside
        testship.paint(window);

        window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

        window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 130 );

        if(keys[0]) // space is pressed
        {





        }


        if(keys[1]) // Up Arrow is pressed
        {
            testship.addxspeed();



        }
        if(keys[2]) // Right Arrow is pressed
        {

        }





    }


    // only edit if you would like to add more key functions
    public void keyPressed(KeyEvent e)
    {

        if( e.getKeyCode()  == KeyEvent.VK_SPACE )
        {
            keys[0]=true;

        }

        if( e.getKeyCode()  == KeyEvent.VK_LEFT )
        {
            keys[1]=true;
        }

        if( e.getKeyCode()  == KeyEvent.VK_RIGHT )
        {
            keys[2]=true;
        }
    }
    /*****~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*****/
// do not edit anything from this point on!!!
    public void keyTyped(KeyEvent e)
    {
        keyPressed( e );
    }
    public void keyReleased(KeyEvent e)
    {

    }

    public void run()
    {
        try
        {
            while( true )
            {
                Thread.sleep( 10 );
                repaint();
            }
        }
        catch( Exception e )
        {
        }
    }
}