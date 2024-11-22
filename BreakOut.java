import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class BreakOut extends JPanel implements Runnable, KeyListener
{
	//Jade Chen

	private boolean[] keys; // this stores booleans for when a key is pressed or not.

	//PROCESS EACH ONE OF THESE ONE AT A TIME
	private Brick testBrick;  //this is only here to make sure the basics work

	private Paddle pad;	// this is the paddle that moves across the bottom of the screen

	private Ball ball; // this is the ball that bounces around the screen

	private ArrayList< Brick > bricks; // this is the list of bricks that are to be drawn on the screen
      

	public BreakOut() // create all instance in here
	{
		int x=0;
		int y=0;
		int w=0;
		int h=0;
		setBackground(Color.WHITE);

		//make the keys array big enough to store all keys pressed
		keys = new boolean[3];		// scroll down to see the keyPressed method

      
      	//Step 1
		//make a new Brick
		testBrick = new Brick(x+=10,y+=110, w+=100, h+=20);

		//go to paint and draw the Brick


		//Step 2
		//make a new Paddle
		pad = new Paddle(200, 500, 100, 10, 50);
		//initialize the Paddle, put the paddle close to the bottom of the screen.

		//go to paint and draw the Paddle


		//Step 3
		//make a new Ball
		//initialize the Ball
		//go to paint and draw the Ball
		ball = new Ball(200, 400, 10 ,10, 6, 6);


		//Step 4
		//make an ArrayList of Bricks
		bricks = new ArrayList<>();



		//Step 5
		//make a for loop to add Bricks to your ArrayList< Brick >
		for(int i=0; i<4; i++){
		for (int j = 0; j < 7; j++) {


			bricks.add(new Brick(x, y, w, h));


			x+= w + 10;


		}
		x = 10;

		y+=h+10;
	}

		// 		each brick will need to have different x & y coordinates, but same width and height
		// 		the x & y coordinates should be based on the width and height you choose
		//go to paint and draw the ArrayList of bricks
		 	
			
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();	//
	}

	public void paint( Graphics window )// all other paint methods and game logic goes in here.
	{
		window.setColor(Color.WHITE); window.fillRect( 0,0, 800, 600); // makes the background white
		window.setColor(Color.BLACK); window.drawRect( 0,0, 800, 600); // draws a black box around the outside

		window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );
		
		if(keys[0]) // space is pressed
		{
			//You will add code here for the ball.
			ball.moveRightLeft();
			ball.moveUpDown();
			ball.keepinBounds();
			if(ball.intersects(pad)){
				ball.changeSpeed();
			}
			boolean lost = false;
			if(ball.getY()>500){


				ball.stop();
				pad.stop();

				lost=true;





			}

			if(lost) {
				Font nFont = new Font("Arial", Font.BOLD, 18);

				window.setFont(nFont);
				window.drawString("GAME OVER!", 350, 350);

			}




		}


		if(keys[1]) // Left Arrow is pressed
		{
			//move the paddle left
			pad.goLeft();
			
			keys[1] = false;
		}
		if(keys[2]) // Right Arrow is pressed
		{	
			//move the paddle right
			pad.goRight();
         
			keys[2] = false;
		}


		//make stuff move

		// draw stuff

		//draw a Brick
		for(int i=0; i<bricks.size(); i++)
		{
			bricks.get(i).paint(window);

		}
		for(int i=0; i<bricks.size(); i++){
			if(bricks.get(i).intersects(ball)){
				ball.changeSpeed();
				bricks.remove(i);
			}
		}
		if(bricks.size()==0){
			Font nFont = new Font("Arial", Font.BOLD, 18);
			window.setFont( nFont );
			window.drawString("YOU WIN!", 350, 350);
			ball.stop();
			pad.stop();


		}

		//draw a Paddle
		pad.paint(window);

		//draw a Ball
		ball.paint(window);


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