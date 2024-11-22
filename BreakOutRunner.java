import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
//Jade Chen
class BreakOutRunner extends JFrame
{
	private final int WIDTH = 820;
	private final int HEIGHT = 640;

	public BreakOutRunner()
	{
		super("BreakOut");

		setSize(WIDTH,HEIGHT);

		//use the ClassTester to test your classes
		//before you start to write the full game
		getContentPane().add( new BreakOut());

		//uncomment this to make the game
		// getContentPane().add( new BreakOut() );
				
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		BreakOutRunner run = new BreakOutRunner();
	}
}