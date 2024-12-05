import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

class game extends JPanel implements Runnable, KeyListener
{




    private boolean[] keys;


    private Ship testship;
    private Asteroid testasteroid;
    private TimerTask task;
    private Timer timer;




    public game() // create all instance in here
    {
        int x=0;
        int y=0;
        int w=0;
        int h=0;
        setBackground(Color.WHITE);
        keys = new boolean[6];		// scroll down to see the keyPressed method
        testship = new Ship(500, 500, 100,100, 0);
        testasteroid = new Asteroid(100,100, 50, 50, 2, 2, 1);
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                testship.dampener();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 100);



        addKeyListener( this );   	//
        setFocusable( true );		// Do NOT DELETE these three lines
        new Thread(this).start();	//
    }



    public void paint(Graphics window )// all other paint methods and game logic goes in here.
    {
        window.setColor(Color.BLACK); window.fillRect( 0,0, getWidth(), getHeight());
        window.setColor(Color.BLACK); window.drawRect( 0,0, getWidth(), getHeight());



        window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

//        window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 130 );

        if(keys[5]) // S is pressed
        {
            testship.goLeftRight();
            testship.goUpDown();
            testship.keepinBounds(getWidth(), getHeight());
            testasteroid.goLeftRight();
            testasteroid.goUpDown();
            testasteroid.keepInBounds(getWidth(), getHeight());






        }


        if(keys[1]) // Left Arrow is pressed
        {
            testship.rotateLeft();
            keys[1] = false;

        }
        if(keys[2]) // Right Arrow is pressed
        {
//            testship.speedupx();
            testship.rotateRight();
            keys[2] = false;

        }
        if(keys[3]){ // Up Arrow
            if(testship.getSpeed()<0.01 || testship.getSpeed()>-0.01) {
                testship.changespeed();
            }
            keys[3] = false;
        }
        if(keys[4]){ // Down Arrow

            keys[4] = false;
        }
        testasteroid.paint(window);
        testship.paint(window);





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
        if( e.getKeyCode()  == KeyEvent.VK_UP )
        {
            keys[3]=true;
        }
        if( e.getKeyCode()  == KeyEvent.VK_DOWN )
        {
            keys[4]=true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            keys[5] = true;
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
                Thread.sleep( 5 );
                repaint();
            }
        }
        catch( Exception e )
        {
        }
    }
}