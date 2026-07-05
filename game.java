import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

class game extends JPanel implements Runnable, KeyListener
{




    private boolean[] keys;


    private Ship testship;
    private Asteroid testasteroid;
    private ArrayList<Asteroid> asteroids;
    private TimerTask task;
    private Timer timer;
    private ArrayList<Bullet> bullets;




    public game() // create all instance in here
    {
        setBackground(Color.WHITE);
        keys = new boolean[6];		// scroll down to see the keyPressed method
        testship = new Ship(500, 500, 100,100, 0);
        testasteroid = new Asteroid(100,100, 50, 50, 1, 1, 1);
        asteroids = new ArrayList<>();
        bullets = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Asteroid curr;
            int x = (int)(Math.random()*(1000));
            int y = (int)(Math.random()*(1000));
            int ysp = 0;
            int xsp =0 ;
            while(ysp==0 || xsp==0) {
                ysp = (int) (Math.random() * 5 - 2);
                xsp = (int) (Math.random() * 4 - 2);
            }


            curr = new Asteroid(x, y, 50, 50, ysp, xsp, 1 );
            asteroids.add(curr);
        }
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
        Font font = new Font("test", 0, 100);





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
            for (int i = 0; i < asteroids.size(); i++) {
                asteroids.get(i).goLeftRight();
                asteroids.get(i).goUpDown();
                asteroids.get(i).keepInBounds(getWidth(), getHeight());
            }

            for(int i = 0; i < asteroids.size(); i++){
                if(testship.intersects(asteroids.get(i))){
                    keys[5] = false;
                }
            } 





        }
         if(keys[0]){
             bullets.add(new Bullet(testship.getnX(),testship.getnY(),0,0));
             bullets.get(bullets.size()-1).shoot(testship, window);
             keys[0] = false;
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
        if(keys[4]){ // Spacebar

            keys[4] = false;
        }
        testasteroid.paint(window);
        for (int i = 0; i < asteroids.size(); i++) {
            asteroids.get(i).paint(window);

        }
        testship.paint(window);

        // Update and draw bullets
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).goLeftRight();
            bullets.get(i).goUpDown();
            bullets.get(i).keepinBounds(getWidth(), getHeight());
            bullets.get(i).paint(window);
        }

        // Bullet-asteroid collision detection (happens every frame)
        for(int i = bullets.size()-1; i >= 0; i--){
            for(int x = asteroids.size()-1; x >= 0; x--){
                if(bullets.get(i).intersects(asteroids.get(x))){
                    bullets.remove(i);
                    asteroids.remove(x);
                    break; // Break inner loop after removing asteroid to avoid checking other asteroids with same bullet
                }
            }
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
